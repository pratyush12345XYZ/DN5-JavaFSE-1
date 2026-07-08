package com.cognizant.countrycrud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.countrycrud.model.Country;
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

        System.out.println("========== Query 1 ==========");
        List<Country> countries1 = countryService.findCountryByNameContaining("ou");
        countries1.forEach(System.out::println);

        System.out.println("\n========== Query 2 ==========");
        List<Country> countries2 = countryService.findCountryByNameContainingSorted("ou");
        countries2.forEach(System.out::println);

        System.out.println("\n========== Query 3 ==========");
        List<Country> countries3 = countryService.findCountryByNameStartingWith("Z");
        countries3.forEach(System.out::println);

    }
}