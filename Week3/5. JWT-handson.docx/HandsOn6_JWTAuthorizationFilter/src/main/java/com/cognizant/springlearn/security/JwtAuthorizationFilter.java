package com.cognizant.springlearn.security;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.ArrayList;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(JwtAuthorizationFilter.class);

    private static final String SECRET =
            "12345678901234567890123456789012";

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {

        super(authenticationManager);

        LOGGER.info("START");

        LOGGER.debug("AuthenticationManager : {}", authenticationManager);
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest req,
            HttpServletResponse res,
            FilterChain chain)
            throws IOException, ServletException {

        LOGGER.info("START");

        String header = req.getHeader("Authorization");

        LOGGER.debug("Authorization Header : {}", header);

        if (header == null || !header.startsWith("Bearer ")) {

            chain.doFilter(req, res);

            return;
        }

        UsernamePasswordAuthenticationToken authentication =
                getAuthentication(req);

        SecurityContextHolder.getContext()
                .setAuthentication(authentication);

        chain.doFilter(req, res);

        LOGGER.info("END");
    }

    private UsernamePasswordAuthenticationToken getAuthentication(
            HttpServletRequest request) {

        String token = request.getHeader("Authorization");

        if (token != null) {

            try {

                Key key = Keys.hmacShaKeyFor(
                        SECRET.getBytes(StandardCharsets.UTF_8));

                Jws<Claims> jws = Jwts.parserBuilder()
                        .setSigningKey(key)
                        .build()
                        .parseClaimsJws(token.replace("Bearer ", ""));

                String user = jws.getBody().getSubject();

                LOGGER.debug("User : {}", user);

                if (user != null) {

                    return new UsernamePasswordAuthenticationToken(
                            user,
                            null,
                            new ArrayList<>());
                }

            } catch (JwtException ex) {

                LOGGER.error("Invalid JWT Token", ex);

                return null;
            }
        }

        return null;
    }

}