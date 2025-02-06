package com.n01617765.j2ee_week3.service;

import com.n01617765.j2ee_week3.model.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee updateEmployee(Employee employee);

    Employee addEmployee(Employee employee);

    void deleteEmployee(Integer id);
    Employee getEmployeeById(Integer id);
}
