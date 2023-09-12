package com.example.departmentservice.service;

import com.example.departmentservice.dto.DepartmentDto;
import com.example.departmentservice.entity.Department;
import com.example.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentRepository departmentRepository;

    @Override
    public void saveDepartment(DepartmentDto departmentDto) {
        Department department = new Department(departmentDto);
        departmentRepository.save(department);
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).get();
        return new DepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map(DepartmentDto::new).collect(Collectors.toList());
    }

    @Override
    public void updateDepartment(Long departmentId, DepartmentDto departmentDto) {
        Department department = departmentRepository.findById(departmentId).get();
        department.setDepartmentName(departmentDto.departmentName());
        department.setDepartmentDescription(departmentDto.departmentDescription());
        department.setDepartmentCode(departmentDto.departmentCode());
        departmentRepository.save(department);
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
