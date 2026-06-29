package com.cognizant.junitspring.exercise3;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getUserById(Long id) {
        return new User(id, "Pratyush Kumar Mohanty");
    }

}