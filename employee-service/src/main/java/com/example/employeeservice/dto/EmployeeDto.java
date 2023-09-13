package com.example.employeeservice.dto;

import com.example.employeeservice.entity.Employee;
import lombok.NonNull;

public record EmployeeDto(
        Long id,
        String firstName,
        String lastName,
        String email,
        Long departmentId) {

    public EmployeeDto(Employee employee) {
        this(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getDepartmentId());
    }
}
