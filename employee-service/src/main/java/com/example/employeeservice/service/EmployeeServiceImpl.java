package com.example.employeeservice.service;

import com.example.employeeservice.dto.APIresponseDto;
import com.example.employeeservice.dto.DepartmentDto;
import com.example.employeeservice.dto.EmployeeDto;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.exception.ResourceNotFoundException;
import com.example.employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    private APIClient apiClient;

    @Override
    public void createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto);
        employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeDto> getEmployees() {
        List<Employee> employeeList= employeeRepository.findAll();
        return employeeList.stream().map(EmployeeDto::new).toList();
    }

    @Override
    public APIresponseDto getEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "id", id));
        DepartmentDto departmentDto = apiClient.getDepartmentById(employee.getDepartmentId());
        return new APIresponseDto(new EmployeeDto(employee), departmentDto);
    }

    @Override
    public void updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "id", id));
        if(employee != null){
            employee.setFirstName(employeeDto.firstName());
            employee.setLastName(employeeDto.lastName());
            employee.setEmail(employeeDto.email());
            employeeRepository.save(employee);
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "id", id));
        if(employee != null){
            employeeRepository.delete(employee);
        }
    }
}
