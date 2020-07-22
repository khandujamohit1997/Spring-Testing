package com.unthinkable.unitTesting;

import com.unthinkable.project.repository.EmployeeRepository;
import com.unthinkable.project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {EmployeeRepository.class, EmployeeService.class})
public class UnitTest {
    @Autowired
    private EmployeeService employeeService;
}
