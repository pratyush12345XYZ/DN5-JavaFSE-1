package com.cognizant.countrycrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.countrycrud.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}