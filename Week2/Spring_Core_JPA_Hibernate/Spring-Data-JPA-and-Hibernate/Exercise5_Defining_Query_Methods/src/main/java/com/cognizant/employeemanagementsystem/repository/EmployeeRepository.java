package com.cognizant.employeemanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.employeemanagementsystem.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Derived query methods
    List<Employee> findByName(String name);

    List<Employee> findByEmailContaining(String email);

    // Custom query using @Query
    @Query("SELECT e FROM Employee e WHERE e.name = :name")
    List<Employee> findEmployeesByName(@Param("name") String name);

    // Named queries
    @Query(name = "Employee.findByEmailNamed")
    List<Employee> findByEmailNamed(@Param("email") String email);

    @Query(name = "Employee.findByNameNamed")
    List<Employee> findByNameNamed(@Param("name") String name);
}