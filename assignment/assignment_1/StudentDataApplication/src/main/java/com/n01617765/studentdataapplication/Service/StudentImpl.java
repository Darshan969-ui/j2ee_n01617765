package com.n01617765.studentdataapplication.Service;

import com.n01617765.studentdataapplication.Entity.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentImpl implements StudentService {

    private final Map<Integer, Student> studentRecords = new HashMap<>();

    public StudentImpl() {
        // Prepopulate with sample students
        studentRecords.put(1, new Student(1, "Darshan", "Male", 27, "d12@example.com", "Toronto", LocalDate.of(1997, 11, 12)));
        studentRecords.put(2, new Student(2, "Ravi", "Male", 25, "r13@example.com", "Mumbai", LocalDate.of(1997, 2, 4)));
        studentRecords.put(3, new Student(3, "Harsh", "Male", 26, "h15@example.com", "Kutch", LocalDate.of(1998, 6, 7)));
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentRecords.values());
    }

    @Override
    public void addStudent(Student student) {
        student.setID(studentRecords.size() + 1);
        studentRecords.put(student.getID(), student);
    }
}
