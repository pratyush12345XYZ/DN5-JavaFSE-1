package com.cognizant.junitspring.exercise9;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest {

    private final UserService userService = new UserService();

    @ParameterizedTest
    @CsvSource({
            "1,true",
            "5,true",
            "10,true",
            "-1,false",
            "0,false"
    })
    void testIsValidUserId(Long id, boolean expected) {

        assertEquals(expected, userService.isValidUserId(id));

    }

}