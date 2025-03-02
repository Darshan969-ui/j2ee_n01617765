package com.n01617765.studentrecordmanagementsystem.Service;

import com.n01617765.studentrecordmanagementsystem.Model.Course;
import com.n01617765.studentrecordmanagementsystem.Model.Student;
import com.n01617765.studentrecordmanagementsystem.Repository.CourseRepo;
import com.n01617765.studentrecordmanagementsystem.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
@Service
public class StudentService {

    private static final Logger logger = Logger.getLogger(StudentService.class.getName());

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    CourseRepo courseRepo;



    //Adduser
    public void addStudent(Student student) {
        logger.info("Adding new user: " + student.getUserName());
        studentRepo.save(student);
    }
    //student login

    public Student StudentLogin(String username, String password) {
        logger.info("Attempting login for username: " + username);
        List<Student> studentList = studentRepo.findByUserName(username);
        return studentList.stream().filter(user -> user.getPassword().equals(password)).findFirst().orElse(null);

    }

    public Student getStudentByUserName(String userName) {
        return studentRepo.findByUserName(userName).stream().findFirst().orElse(null);
    }
    public Student getStudentById(Long studentId) {
        return studentRepo.findById(studentId).orElse(null);
    }
//    public void enrollStudentInCourse(Long studentId, Long courseId) {
//        Optional<Student> studentOpt = studentRepo.findById(studentId);
//        Optional<Course> courseOpt = courseRepo.findById(courseId);
//
//        if (studentOpt.isPresent() && courseOpt.isPresent()) {
//            Student student = studentOpt.get();
//            Course course = courseOpt.get();
//
//            student.getCourses().add(course);
//            studentRepo.save(student);
//        }
//    }

//    public void dropCourse(Long studentId, Long courseId) {
//        Optional<Student> studentOpt = studentRepo.findById(studentId);
//        Optional<Course> courseOpt = courseRepo.findById(courseId);
//
//        if (studentOpt.isPresent() && courseOpt.isPresent()) {
//            Student student = studentOpt.get();
//            Course course = courseOpt.get();
//
//            student.getCourses().remove(course);
//            studentRepo.save(student);
//        }
//    }

    public void enrollStudentInCourse(Long studentId, Long courseId) {
        Student student = studentRepo.findById(studentId).orElse(null);
        if (student != null) {
            List<Long> courses = student.getEnrolledCourseIds();
            if (!courses.contains(courseId)) {
                courses.add(courseId);
                student.setEnrolledCourseIds(courses);
                studentRepo.save(student);
            }
        }
    }

    public void dropCourse(Long studentId, Long courseId) {
        Student student = studentRepo.findById(studentId).orElse(null);
        if (student != null) {
            List<Long> courses = student.getEnrolledCourseIds();
            courses.remove(courseId);
            student.setEnrolledCourseIds(courses);
            studentRepo.save(student);
        }
    }

    // ✅ Fetch all students
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }
    // ✅ Update an existing Student
    public Student updateStudent(Long id, Student updatedStudent) {
        return studentRepo.findById(id)
                .map(student -> {
                    student.setFirstName(updatedStudent.getFirstName());
                    student.setLastName(updatedStudent.getLastName());
                    student.setAge(updatedStudent.getAge());
                    student.setGender(updatedStudent.getGender());
                    student.setAddress(updatedStudent.getAddress());
                    student.setEmail(updatedStudent.getEmail());
                    student.setPhone(updatedStudent.getPhone());
                    return studentRepo.save(student);
                })
                .orElseThrow(() -> new RuntimeException("Student with ID " + id + " not found!"));
    }
    // ✅ Delete a student by ID
    public void deleteStudent(Long id) {
        if (!studentRepo.existsById(id)) {
            throw new RuntimeException("Student with ID " + id + " not found!");
        }
        studentRepo.deleteById(id);
    }
}
