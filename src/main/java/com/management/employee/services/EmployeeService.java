package com.management.employee.services;


import com.management.employee.entities.Employee;

import java.util.List;

public interface EmployeeService {
    void save(Employee employee);

    List<Employee> getEmployees();

    Employee update(Long id, Employee employee);

    Employee deleteById(Long id);

    Employee getEmployee(Long id);
}
