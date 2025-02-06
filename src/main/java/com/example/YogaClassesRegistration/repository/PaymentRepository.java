package com.example.YogaClassesRegistration.repository;

import com.example.YogaClassesRegistration.model.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payments, String>
{
}
