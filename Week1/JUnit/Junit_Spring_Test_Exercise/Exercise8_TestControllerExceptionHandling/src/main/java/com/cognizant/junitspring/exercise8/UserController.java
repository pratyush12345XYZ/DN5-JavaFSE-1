package com.cognizant.junitspring.exercise8;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
public class UserController {

    @GetMapping("/users")
    public String getUser() {

        throw new NoSuchElementException();

    }

}