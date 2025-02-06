package com.example.YogaClassesRegistration.service;

import com.example.YogaClassesRegistration.model.Payments;
import com.example.YogaClassesRegistration.model.Users;
import com.example.YogaClassesRegistration.repository.PaymentRepository;
import com.example.YogaClassesRegistration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YogaAppService
{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private Users users;
    @Autowired
    private Payments payments;

    public Users findById(String email)
    {
        return userRepository.findById(email).orElse(null);
    }

    public void saveUser(Users user)
    {
        userRepository.save(user);
    }

    public Boolean checkPaymentStatus(String email, String month, int year)
    {
        String payId = email+month+year;
        if(paymentRepository.findById(payId).isPresent()){
            return true;
        } else {
            return false;
        }
    }

    public boolean CompletePayment(String email, String month, int year, Users user, String batch)
    {
        String payId = email+month+year;
        String monthOfPay  = month+year;
        if(paymentRepository.findById(payId).isPresent()){
            return false;
        }else {
            payments.setPaymentId(payId);
            payments.setMonthOfPayment(monthOfPay);
            payments.setUser(user);
            payments.setBatch(batch);

            paymentRepository.save(payments);

            return true;
        }
    }
}
