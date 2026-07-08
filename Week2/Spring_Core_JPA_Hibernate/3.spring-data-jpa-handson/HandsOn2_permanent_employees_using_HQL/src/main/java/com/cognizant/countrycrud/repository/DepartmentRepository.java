package com.cognizant.countrycrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.countrycrud.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}