package com.example.employeeservice.service;

import com.example.employeeservice.dto.APIresponseDto;
import com.example.employeeservice.dto.EmployeeDto;
import java.util.List;

public interface EmployeeService {
    void createEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getEmployees();
    APIresponseDto getEmployee(Long id);
    void updateEmployee(Long id, EmployeeDto employeeDto);
    void deleteEmployee(Long id);
}
