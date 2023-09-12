package com.example.departmentservice.entity;

import com.example.departmentservice.dto.DepartmentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;

    public Department(DepartmentDto departmentDto){
        this.departmentName = departmentDto.departmentName();
        this.departmentDescription = departmentDto.departmentDescription();
        this.departmentCode = departmentDto.departmentCode();
    }

}
