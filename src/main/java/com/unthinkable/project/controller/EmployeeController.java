package com.unthinkable.project.controller;

import com.unthinkable.project.model.Employee;
import com.unthinkable.project.repository.EmployeeRepository;
import com.unthinkable.project.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping(value = "all", produces = "application/json")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployee();
    }

    @GetMapping(value = "{name}")
    public Employee getEmployeeByName(@PathVariable("name") String name) {
        return employeeService.getEmployeeByName(name);
    }

    @PostMapping("add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) throws Exception {
        employeeService.addEmployee(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
    }

    @PostMapping(path = "add/mockito", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Employee> addEmployeeMockito(@RequestBody Employee employee) throws Exception {

        employeeRepository.save(employee);

        System.out.println(employeeRepository.findByName("Mohit"));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(employee.getId())
            .toUri();

        //Send location in response
        return ResponseEntity.created(location).build();
    }
}
