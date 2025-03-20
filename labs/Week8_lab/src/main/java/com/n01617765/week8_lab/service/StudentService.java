package com.n01617765.week8_lab.service;

import com.n01617765.week8_lab.model.Student;
import com.n01617765.week8_lab.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepo studentRepo;


    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    // to fetch a student by using their id
    public Student getStudentById(int id) {
        Optional<Student> student = studentRepo.findById(id);
        return student.orElse(null);
    }
    //to get all student info
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    // in order to add a student
    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    //to update a student
    public Student updateStudent(Integer id, Student studentDetails) {
        Optional<Student> existingStudentOpt = studentRepo.findById(id);

        if (existingStudentOpt.isPresent()) {
            Student existingStudent = existingStudentOpt.get();
            existingStudent.setName(studentDetails.getName());
            existingStudent.setAge(studentDetails.getAge());
            existingStudent.setGender(studentDetails.getGender());
            return studentRepo.save(existingStudent);
        } else {
            throw new RuntimeException("Student with ID " + id + " not found!");
        }
    }

    //to delete a student
    public void deleteStudentById(int id) {
        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
        }else{
            throw new RuntimeException("Student with id " + id + " not found");
        }

    }



}
