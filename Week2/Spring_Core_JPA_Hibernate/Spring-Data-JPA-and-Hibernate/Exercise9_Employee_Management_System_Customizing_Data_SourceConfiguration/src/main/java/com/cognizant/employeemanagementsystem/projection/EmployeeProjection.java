package com.cognizant.employeemanagementsystem.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeProjection {

    Long getId();

    String getName();

    String getEmail();

    @Value("#{target.name + ' - ' + target.email}")
    String getEmployeeDetails();
}