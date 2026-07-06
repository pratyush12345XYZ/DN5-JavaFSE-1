package com.cognizant.countrycrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.countrycrud.service.CountryService;

@SpringBootApplication
public class CountryCrudApplication implements CommandLineRunner {

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        SpringApplication.run(CountryCrudApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        countryService.getAllCountries().forEach(System.out::println);

    }
}