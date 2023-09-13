package com.example.employeeservice.controller;

import com.example.employeeservice.dto.APIresponseDto;
import com.example.employeeservice.dto.EmployeeDto;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.service.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private EmployeeServiceImpl employeeServiceimpl;

    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeDto employeeDto) {
        employeeServiceimpl.createEmployee(employeeDto);
        return new ResponseEntity<>("Employee added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> getEmployees() {
        List<EmployeeDto> employeeList = employeeServiceimpl.getEmployees();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIresponseDto> getEmployee(@PathVariable Long id) {
        APIresponseDto apIresponseDto = employeeServiceimpl.getEmployee(id);
        return new ResponseEntity<>(apIresponseDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        employeeServiceimpl.updateEmployee(id, employeeDto);
        return new ResponseEntity<>("Employee updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeServiceimpl.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
    }

}
