package com.management.employee.repository;

import com.management.employee.entities.Employee;
import com.management.employee.exceptions.InvalidFieldException;
import com.management.employee.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class EmployeeRepository implements EmployeeService {
    public static Map<Long, Employee> employees = new HashMap<>();

    @Override
    public void save(Employee employee) {
        log.info("Saving employee");
        if (employees.containsKey(employee.getId())) {
            log.error("Employee already saved. Id should be different");
            throw new InvalidFieldException.Builder().build();
        }
        employees.put(employee.getId(), employee);
    }

    @Override
    public List<Employee> getEmployees() {
        log.info("Getting Employees");
        return new ArrayList<>(employees.values());
    }

    @Override
    public Employee update(Long id, Employee employee) {
        return employees.put(id, employee);
    }

    @Override
    public Employee deleteById(Long id) {
        return employees.remove(id);
    }

    @Override
    public Employee getEmployee(Long id) {
        return employees.getOrDefault(id, null);
    }
}
