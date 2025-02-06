package com.example.YogaClassesRegistration.repository;

import com.example.YogaClassesRegistration.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, String>
{
}
