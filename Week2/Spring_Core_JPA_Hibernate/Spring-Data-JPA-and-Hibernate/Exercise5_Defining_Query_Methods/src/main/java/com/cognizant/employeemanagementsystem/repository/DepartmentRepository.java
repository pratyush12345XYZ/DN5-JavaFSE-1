package com.cognizant.employeemanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.employeemanagementsystem.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Derived query method
    List<Department> findByName(String name);

    // Custom query using @Query
    @Query("SELECT d FROM Department d WHERE d.name = :name")
    List<Department> findDepartmentsByName(@Param("name") String name);

    // Named query
    @Query(name = "Department.findByNameNamed")
    List<Department> findByNameNamed(@Param("name") String name);
}