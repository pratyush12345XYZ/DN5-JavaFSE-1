package com.cognizant.junitspring.exercise1.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    void testAdd() {

        int result = calculatorService.add(10, 20);

        assertEquals(30, result);

    }

}