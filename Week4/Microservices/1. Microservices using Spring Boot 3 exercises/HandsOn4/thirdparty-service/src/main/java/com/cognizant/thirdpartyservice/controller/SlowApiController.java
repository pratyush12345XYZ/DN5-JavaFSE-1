package com.cognizant.thirdpartyservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SlowApiController {

    @GetMapping("/payment")
    public String payment() throws InterruptedException {

        Thread.sleep(5000);

        return "Payment Successful";
    }
}