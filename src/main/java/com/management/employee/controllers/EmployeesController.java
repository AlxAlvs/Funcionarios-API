package com.management.employee.controllers;

import com.management.employee.entities.Employee;
import com.management.employee.services.EmployeeService;
import com.management.employee.entities.dtos.EmployeeDTO;
import com.management.employee.usecases.ValidateEmployeeFields;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "/api/v1")
@Api(value = "Employee", tags = {"Employees"})
@RequiredArgsConstructor
public class EmployeesController {

    @Autowired
    private final EmployeeService employeeService;

    @Autowired
    private final ValidateEmployeeFields validateEmployeeFields;

    @ApiOperation(
        value = "Save Employee",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(
        value = {
            @ApiResponse(code = 201, message = "Employee saved successfully"),
            @ApiResponse(code = 400, message = "Bad request")
        }
    )
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(path = "/employee", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Void> saveEmployee (
            @RequestBody @Valid EmployeeDTO employeeDTO) {
        log.info("Receiving employee");
        employeeService.save(validateEmployeeFields.execute(employeeDTO));
        log.info("Saved employee successfully");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get Employees")
    @ApiResponses(
        value = {
            @ApiResponse(code = 200, message = "Employees returned successfully"),
            @ApiResponse(code = 400, message = "Bad request")
        }
    )
    @GetMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> getEmployees() {
        log.info("Fetching employees request");
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get Employee by id")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Employees returned successfully"),
                    @ApiResponse(code = 400, message = "Bad request")
            }
    )
    @GetMapping(path = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployees(@NonNull @PathVariable Long id) {
        log.info("Fetching employee request");
        return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
    }

    @ApiOperation(value = "update Employees")
    @ApiResponses(
        value = {
            @ApiResponse(code = 200, message = "Employees updated successfully"),
            @ApiResponse(code = 400, message = "Bad request")
        }
    )
    @PutMapping("update/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @NonNull @Valid @RequestBody EmployeeDTO employee,
            @NonNull @PathVariable Long id) {
        var employeeReturned = employeeService.update(id, validateEmployeeFields.execute(employee));
        return ResponseEntity.ok(employeeReturned);
    }

    @ApiOperation(value = "Remove employee")
    @ApiResponses(
        value = {
            @ApiResponse(code = 200, message = "Removed employee successfully"),
            @ApiResponse(code = 400, message = "Bad request")
        }
    )
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@NonNull @PathVariable Long id) {
        var employeeReturned = employeeService.deleteById(id);
        return ResponseEntity.ok(employeeReturned);
    }
}
