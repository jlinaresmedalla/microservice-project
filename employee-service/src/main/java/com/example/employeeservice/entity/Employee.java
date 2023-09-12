package com.example.employeeservice.entity;

import com.example.employeeservice.dto.EmployeeDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique=true, nullable=false)
    private String email;

    public Employee(EmployeeDto employeeDto) {
        this.firstName = employeeDto.firstName();
        this.lastName = employeeDto.lastName();
        this.email = employeeDto.email();
    }

}
