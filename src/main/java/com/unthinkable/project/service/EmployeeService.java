package com.unthinkable.project.service;

import com.unthinkable.project.model.Employee;
import java.util.List;

public interface EmployeeService {

    public Employee getEmployeeByName(String name);

    public Employee getEmployeeByAge(String age);

    public Employee addEmployee(Employee employee);

    public List<Employee> getAllEmployee();
}
