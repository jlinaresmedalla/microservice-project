package com.example.departmentservice.dto;

import com.example.departmentservice.entity.Department;

public record DepartmentDto(Long id, String departmentName, String departmentDescription, String departmentCode) {

    public DepartmentDto(Department department) {
        this(department.getId(), department.getDepartmentName(), department.getDepartmentDescription(), department.getDepartmentCode());
    }

}
