package com.management.employee.mapper;

import com.management.employee.entities.Employee;
import com.management.employee.entities.dtos.EmployeeDTO;


public class EmployeeMapper {

    public static Employee dtoToEntity(EmployeeDTO employeeDTO) {
        return Employee.builder()
                .id(employeeDTO.getId())
                .name(employeeDTO.getName())
                .phone(employeeDTO.getPhone())
                .address(employeeDTO.getAddress())
                .salary(employeeDTO.getSalary())
                .designation(employeeDTO.getDesignation())
                .build();
    }
}
