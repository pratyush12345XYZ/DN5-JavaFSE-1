package com.cognizant.springlearn.controller;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

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

        String token = generateJwt(user);

        LOGGER.debug("Generated JWT : {}", token);

        Map<String, String> map = new HashMap<>();

        map.put("token", token);

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

    private String generateJwt(String user) {

        LOGGER.debug("START - generateJwt()");

        Key key = Keys.hmacShaKeyFor(
                "12345678901234567890123456789012".getBytes(StandardCharsets.UTF_8));

        String token = Jwts.builder()
                .setSubject(user)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1200000))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        LOGGER.debug("Generated Token : {}", token);

        LOGGER.debug("END - generateJwt()");

        return token;
    }

}