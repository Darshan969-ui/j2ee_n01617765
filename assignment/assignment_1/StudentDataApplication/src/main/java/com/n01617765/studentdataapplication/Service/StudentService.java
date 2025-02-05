package com.n01617765.studentdataapplication.Service;
import com.n01617765.studentdataapplication.Entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {
    List<Student> getAllStudents();
    void addStudent(Student student);
}
