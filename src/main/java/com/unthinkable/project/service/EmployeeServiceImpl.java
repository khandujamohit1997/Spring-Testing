package com.unthinkable.project.service;

import com.unthinkable.project.model.Employee;
import com.unthinkable.project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public Employee getEmployeeByAge(String age) {
        return employeeRepository.findByAge(age);
    }

    @Override
    public Employee addEmployee(Employee employee) {
       return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
}
