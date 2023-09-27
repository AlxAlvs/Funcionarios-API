package com.management.employee.usecases;

import com.management.employee.entities.Employee;
import com.management.employee.entities.dtos.EmployeeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class ValidateEmployeeFields {


    public Employee execute(EmployeeDTO employeeDto) {
        return Employee.builder().id(employeeDto.getId()).build();
    }
}
