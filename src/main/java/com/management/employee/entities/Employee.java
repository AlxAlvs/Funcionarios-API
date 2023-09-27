package com.management.employee.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private String designation;
    private String salary;
    private String phone;
    private String address;
}
