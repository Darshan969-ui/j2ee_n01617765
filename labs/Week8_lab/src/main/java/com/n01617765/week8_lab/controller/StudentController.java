package com.n01617765.week8_lab.controller;


import com.n01617765.week8_lab.model.Student;
import com.n01617765.week8_lab.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {

        private final StudentService studentService;


        //dependancy injection
        @Autowired
        public StudentController(StudentService studentService) {
            this.studentService = studentService;

        }
        //to add a student to the db
        @PostMapping("/add")
        public ResponseEntity<String> addStudent(@RequestBody Student student) {
            Optional<Student> existingStudent = Optional.ofNullable(studentService.addStudent(student));

            if (existingStudent.isPresent()) {

                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("the student with the id: "+existingStudent.get() + "has been added");
            }
                studentService.addStudent(student);
                return ResponseEntity.status(HttpStatus.CREATED).body("Student added successfully!");
        }

    //to update a student info by id
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable  int id, @RequestBody Student student) {
            Optional<Student> newStudent = Optional.ofNullable(studentService.updateStudent(id, student));
            if (newStudent.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(newStudent.get());
            }
            else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
            }

    }
//to get all the student info
    @GetMapping("searchAll")
    public ResponseEntity<List<Student>> searchAllStudents() {
             List<Student> getStudent = studentService.getAllStudents();
             return new ResponseEntity<>(getStudent, HttpStatus.OK);
    }

    // to get all the student info by id
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
            Student singleStudent = studentService.getStudentById(id);
            return new ResponseEntity<>(singleStudent, HttpStatus.OK);
    }
    //to delete a student by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int id) {
            Optional<Student> singleStudent = Optional.ofNullable(studentService.getStudentById(id));
        if (singleStudent.isPresent()) {
            studentService.deleteStudentById(id);
            return new ResponseEntity<>(singleStudent.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
            //return new ResponseEntity<>(singleStudent, HttpStatus.OK);
    }

}
