package com.example.YogaClassesRegistration.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Entity
public class Users
{
    private String name;
    private int age;
    @Id
    private String email;
    @OneToMany(mappedBy = "user")
    private List<Payments> payments;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }


    public List<Payments> getPayments()
    {
        return payments;
    }

    public void setPayments(List<Payments> payments)
    {
        this.payments = payments;
    }
}
