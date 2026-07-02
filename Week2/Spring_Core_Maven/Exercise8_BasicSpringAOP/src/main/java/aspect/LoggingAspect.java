package com.library.aspect;

public class LoggingAspect {

    public void beforeAdvice() {
        System.out.println("Before method execution...");
    }

    public void afterAdvice() {
        System.out.println("After method execution...");
    }

}