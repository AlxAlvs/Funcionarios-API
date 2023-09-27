package com.management.employee.entities.dtos;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class EmployeeDTO {

    @NotBlank(message = "Id is empty")
    private Long id;
    @NotBlank(message = "Name is empty")
    private String name;
    private String designation;
    private String salary;
    private String phone;
    private String address;

}
