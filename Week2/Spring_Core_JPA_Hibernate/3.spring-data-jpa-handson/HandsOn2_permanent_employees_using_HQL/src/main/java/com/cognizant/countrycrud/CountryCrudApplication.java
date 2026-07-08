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

        testGetAllPermanentEmployees();
    }

    public static void testGetAllPermanentEmployees() {

        LOGGER.info("Start");

        List<Employee> employees =
                employeeService.getAllPermanentEmployees();

        LOGGER.debug("Permanent Employees: {}", employees);

        employees.forEach(e ->
                LOGGER.debug("Skills: {}", e.getSkillList()));

        LOGGER.info("End");
    }
}