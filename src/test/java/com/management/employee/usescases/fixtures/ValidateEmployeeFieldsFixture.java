package com.management.employee.usescases.fixtures;


import com.management.employee.entities.Employee;
import com.management.employee.entities.dtos.EmployeeDTO;


public class ValidateEmployeeFieldsFixture {

    public static EmployeeDTO getValidEmployeeDTO() {
        return EmployeeDTO.builder()
                .id(1L)
                .build();
    }

    public static Employee getEmployee() {
        return Employee.builder()
                .id(1L)
                .build();
    }
}
