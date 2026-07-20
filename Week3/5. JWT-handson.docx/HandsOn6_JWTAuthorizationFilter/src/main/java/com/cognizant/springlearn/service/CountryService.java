package com.cognizant.springlearn.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

    @SuppressWarnings("unchecked")
    public Country getCountry(String code) throws CountryNotFoundException {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        List<Country> countryList =
                context.getBean("countryList", List.class);

        for (Country country : countryList) {

            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }

        }

        throw new CountryNotFoundException();

    }

}