package com.cognizant.junitspring.exercise2.repository;

import com.cognizant.junitspring.exercise2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}