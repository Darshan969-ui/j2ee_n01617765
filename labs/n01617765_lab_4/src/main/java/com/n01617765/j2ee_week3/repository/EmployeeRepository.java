package com.n01617765.j2ee_week3.repository;

import com.n01617765.j2ee_week3.model.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//    List<Employee> findAll();
//    Employee save(Employee employee);
//    void deleteById(Integer id);
//    Employee findById(Integer id);
}
