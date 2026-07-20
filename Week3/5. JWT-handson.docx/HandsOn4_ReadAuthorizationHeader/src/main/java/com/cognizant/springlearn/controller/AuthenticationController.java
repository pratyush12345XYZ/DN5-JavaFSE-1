package com.cognizant.springlearn.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestHeader("Authorization") String authHeader) {

        LOGGER.info("START");

        LOGGER.debug("Authorization Header : {}", authHeader);

        String user = getUser(authHeader);

        LOGGER.debug("User : {}", user);

        Map<String, String> map = new HashMap<>();

        map.put("token", "");

        LOGGER.info("END");

        return map;
    }

    private String getUser(String authHeader) {

        LOGGER.debug("START - getUser()");

        String encodedCredentials =
                authHeader.substring("Basic ".length());

        LOGGER.debug("Encoded Credentials : {}", encodedCredentials);

        byte[] decodedBytes =
                Base64.getDecoder().decode(encodedCredentials);

        String credentials =
                new String(decodedBytes, StandardCharsets.UTF_8);

        LOGGER.debug("Decoded Credentials : {}", credentials);

        String user =
                credentials.substring(0, credentials.indexOf(":"));

        LOGGER.debug("Username : {}", user);

        LOGGER.debug("END - getUser()");

        return user;
    }

}