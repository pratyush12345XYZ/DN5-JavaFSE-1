package com.cognizant.countrycrud;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.countrycrud.model.Employee;
import com.cognizant.countrycrud.service.EmployeeService;

@SpringBootApplication
public class CountryCrudApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryCrudApplication.class);

    private static EmployeeService employeeService;

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(CountryCrudApplication.class, args);

        employeeService = context.getBean(EmployeeService.class);

        testGetAverageSalary();
    }

    public static void testGetAverageSalary() {

        LOGGER.info("Start");

        double averageSalary = employeeService.getAverageSalary(1);

        LOGGER.debug("Average Salary = {}", averageSalary);

        LOGGER.info("End");
    }
}