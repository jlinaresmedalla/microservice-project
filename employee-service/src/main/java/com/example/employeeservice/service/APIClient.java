package com.example.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.employeeservice.dto.DepartmentDto;

//@FeignClient(value = "DEPARTMENT-SERVICE", url = "http://localhost:8080")
@FeignClient(name = "DEPARTMENT-SERVICE") // Load balancer embeded will be used to call the service
public interface APIClient {

    @GetMapping("/{id}")
    DepartmentDto getDepartmentById(@PathVariable Long id);

}
