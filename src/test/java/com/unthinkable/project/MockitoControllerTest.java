package com.unthinkable.project;

import com.unthinkable.project.controller.EmployeeController;
import com.unthinkable.project.model.Employee;
import com.unthinkable.project.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MockitoControllerTest {

    @InjectMocks
    EmployeeController employeeController;

    @Mock
    EmployeeRepository employeeRepository;

    @BeforeEach
    public void add() {
        Employee employee = new Employee("Mohit", "22");
        employeeRepository.save(employee);
    }

    @Test
    public void testAddEmployee() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Employee employee = new Employee("Mohit", "22");
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
        ResponseEntity<Employee> responseEntity = employeeController.addEmployeeMockito(employee);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/");
    }
}
