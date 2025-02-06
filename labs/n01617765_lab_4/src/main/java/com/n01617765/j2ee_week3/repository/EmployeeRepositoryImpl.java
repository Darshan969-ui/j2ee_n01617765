package com.n01617765.j2ee_week3.repository;

import com.n01617765.j2ee_week3.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final Map<Integer, Employee> employeeMap = new HashMap<>();
    private int idCounter = 1;

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employeeMap.values());
    }

    @Override
    public Employee save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(idCounter++);
        }
        employeeMap.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public void deleteById(Integer id) {
        employeeMap.remove(id);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeMap.values()
                .stream()
                .filter(employee -> employee.getId().equals(id)).findFirst().orElse(null);

    }

}
