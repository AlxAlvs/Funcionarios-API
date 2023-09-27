package com.management.employee.usescases;



import com.management.employee.entities.Employee;
import com.management.employee.exceptions.InvalidFieldException;
import com.management.employee.repository.EmployeeRepository;
import com.management.employee.usecases.ValidateEmployeeFields;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.management.employee.usescases.fixtures.ValidateEmployeeFieldsFixture.getEmployee;
import static com.management.employee.usescases.fixtures.ValidateEmployeeFieldsFixture.getValidEmployeeDTO;


@DisplayName("Validate employee fields unit test")
@ExtendWith(MockitoExtension.class)
public class ValidateEmployeeFieldsUnitTest {

    @InjectMocks
    private ValidateEmployeeFields validateEmployeeFields;

    @InjectMocks
    private EmployeeRepository employeeRepository;

    @Test
    @DisplayName("Should validate fields successfully")
    void shouldValidateTransactionFields() {
        Employee employee = validateEmployeeFields.execute(getValidEmployeeDTO());
        Assertions.assertThat(employee.getId()).isEqualTo(1L);
    }

    @Test
    @DisplayName("Should throw exception when id exists")
    void shouldThrowExceptionWhenIdExists() {
        employeeRepository.save(getEmployee());
        Assertions.assertThatExceptionOfType(InvalidFieldException.class)
                .isThrownBy(() -> employeeRepository.save(getEmployee()));
    }

}
