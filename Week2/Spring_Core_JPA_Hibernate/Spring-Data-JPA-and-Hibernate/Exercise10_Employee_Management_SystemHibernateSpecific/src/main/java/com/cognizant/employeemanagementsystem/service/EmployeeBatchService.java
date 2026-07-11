package com.cognizant.employeemanagementsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.employeemanagementsystem.entity.Employee;
import com.cognizant.employeemanagementsystem.repository.EmployeeRepository;

@Service
public class EmployeeBatchService {

    private final EmployeeRepository employeeRepository;

    public EmployeeBatchService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public List<Employee> saveEmployeesInBatch(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }
}