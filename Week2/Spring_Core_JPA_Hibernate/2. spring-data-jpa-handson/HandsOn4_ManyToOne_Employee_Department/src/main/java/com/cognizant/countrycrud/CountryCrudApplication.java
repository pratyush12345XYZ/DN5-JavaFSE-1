package com.cognizant.countrycrud;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.countrycrud.model.Department;
import com.cognizant.countrycrud.model.Employee;
import com.cognizant.countrycrud.service.DepartmentService;
import com.cognizant.countrycrud.service.EmployeeService;
import com.cognizant.countrycrud.service.SkillService;

@SpringBootApplication
public class CountryCrudApplication {

    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(CountryCrudApplication.class, args);

        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);

        testUpdateEmployee();

        // testGetEmployee();
        // testUpdateEmployee();
    }

    private static void testGetEmployee() {

        System.out.println("========== Get Employee ==========");

        Employee employee = employeeService.get(1);

        System.out.println(employee);

        System.out.println(employee.getDepartment());
    }

    private static void testAddEmployee() {

        System.out.println("========== Add Employee ==========");

        Employee employee = new Employee();

        employee.setName("Amit");
        employee.setSalary(new BigDecimal("60000"));
        employee.setPermanent(true);
        employee.setDateOfBirth(Date.valueOf("2000-05-15"));

        Department department = departmentService.get(1);

        employee.setDepartment(department);

        employeeService.save(employee);

        System.out.println(employee);
    }

    private static void testUpdateEmployee() {

        System.out.println("========== Update Employee ==========");

        Employee employee = employeeService.get(1);

        Department department = departmentService.get(3);

        employee.setDepartment(department);

        employeeService.save(employee);

        System.out.println(employee);
    }
}