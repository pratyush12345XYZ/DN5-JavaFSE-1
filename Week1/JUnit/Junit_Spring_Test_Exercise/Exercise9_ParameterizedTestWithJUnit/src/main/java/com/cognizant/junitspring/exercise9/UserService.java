package com.cognizant.junitspring.exercise9;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public boolean isValidUserId(Long id) {

        return id > 0;

    }

}