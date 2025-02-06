package com.example.YogaClassesRegistration;

import com.example.YogaClassesRegistration.model.Users;

import com.example.YogaClassesRegistration.service.YogaAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"email", "month", "year", "batch", "userPay"})
public class YogaAppController {

    @Autowired
    private YogaAppService Service;

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @PostMapping("/registerUser")
    public String registerUser(@RequestParam String name, @RequestParam int age, @RequestParam String email,
                               @RequestParam String month, @RequestParam int year, @RequestParam String batch,
                               Model model) {

        Users user = Service.findById(email);
        if (user == null) {

            user = new Users();
            user.setName(name);
            user.setAge(age);
            user.setEmail(email);
            Service.saveUser(user);
        }

        Boolean paymentStatus = Service.checkPaymentStatus(email, month, year);

        if (paymentStatus) {
            model.addAttribute("info", "Payment already done for " + month + " " + year);
            return "info";
        } else {
            model.addAttribute("userPay", user);
            model.addAttribute("email", email);
            model.addAttribute("month", month);
            model.addAttribute("year", year);
            model.addAttribute("batch", batch);
            return "payment";
        }
    }

    @PostMapping("/payment")
    public String payment(@ModelAttribute("email") String email,
                          @ModelAttribute("month") String month,
                          @ModelAttribute("year") int year, @ModelAttribute("userPay") Users userPay, @ModelAttribute("batch") String batch,
                          Model model) {

        if (Service.CompletePayment(email, month, year, userPay, batch)) {
            model.addAttribute("info", "Payment Successfully Done for " + month + " " + year);
            return "info";
        } else {
            model.addAttribute("info", "Payment Already Done for "+ month + " " + year);
            return "info";
        }
    }
}
