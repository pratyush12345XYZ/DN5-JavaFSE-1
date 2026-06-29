package com.cognizant.junitspring.exercise5;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User saveUser(User user) {
        return user;
    }

}