package com.example.YogaClassesRegistration.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Payments
{
    private String monthOfPayment;
    @Id
    private String paymentId;
    @ManyToOne
    private Users user;
    private String batch;

    public String getMonthOfPayment()
    {
        return monthOfPayment;
    }

    public void setMonthOfPayment(String monthOfPayment)
    {
        this.monthOfPayment = monthOfPayment;
    }

    public String getPaymentId()
    {
        return paymentId;
    }

    public void setPaymentId(String paymentId)
    {
        this.paymentId = paymentId;
    }

    public Users getUser()
    {
        return user;
    }

    public void setUser(Users user)
    {
        this.user = user;
    }

    public String getBatch()
    {
        return batch;
    }

    public void setBatch(String batch)
    {
        this.batch = batch;
    }
}
