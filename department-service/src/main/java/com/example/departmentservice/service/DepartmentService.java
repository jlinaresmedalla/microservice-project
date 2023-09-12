package com.example.departmentservice.service;

import com.example.departmentservice.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    void saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentById(Long departmentId);
    List<DepartmentDto> getAllDepartments();
    void updateDepartment(Long departmentId, DepartmentDto departmentDto);
    void deleteDepartmentById(Long departmentId);

}
