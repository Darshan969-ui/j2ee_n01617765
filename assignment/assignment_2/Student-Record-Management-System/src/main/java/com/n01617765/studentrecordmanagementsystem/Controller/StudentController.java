package com.n01617765.studentrecordmanagementsystem.Controller;

import com.n01617765.studentrecordmanagementsystem.Model.Course;
import com.n01617765.studentrecordmanagementsystem.Model.Student;
import com.n01617765.studentrecordmanagementsystem.Repository.StudentRepo;
import com.n01617765.studentrecordmanagementsystem.Service.CourseService;
import com.n01617765.studentrecordmanagementsystem.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@Controller
public class StudentController {


    private final StudentService studentService;

    private final CourseService courseService;

    @Autowired
    public StudentController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }



    // Show Login Page
    @GetMapping("/Login")
    public String showLoginPage() {
        return "Login";
    }  // User Login
    @PostMapping("/loginUser")
    public String loginUser(@RequestParam("userName") String userName,
                            @RequestParam("password") String password,
                            Model model) {
        Student authenticatedUser = studentService.StudentLogin(userName, password);

        if (authenticatedUser == null) {
            model.addAttribute("error", "Invalid username or password");
            return "Login"; // Redirect back to login page with error message
        }

        model.addAttribute("student", authenticatedUser);
        return "redirect:/Home?userName=" +userName; // Redirect to home page upon successful login
    }
    // Show Sign Up Page
    @GetMapping("/addUser")
    public String showAddUserForm(Model model) {
        model.addAttribute("addNewUser", new Student());  // Initialize empty form
        return "Sign_up";  // Ensure there is a signup.html
    }

    // Add a New User
    @PostMapping("/addUser")
    public String addUser(@Valid @ModelAttribute("addNewUser") Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("addNewUser", student);  // Pass the object with validation errors
            return "Sign_up"; // Re-render the form with validation errors
        }
        studentService.addStudent(student);
        return "redirect:/Login"; // Redirect to login page after successful sign-up
    }

    @GetMapping("/Home")
    public String home(@RequestParam String userName, Model model) {
        Student student = studentService.getStudentByUserName(userName);
        System.out.println(userName);
        if (student == null) {
            return "redirect:/Login"; // Redirect to login if student is not found
        }
       // student.setCourses(new HashSet<>(student.getCourses()));
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("student", student);
        model.addAttribute("courses", courses);

        return "Home";
    }


    @PostMapping("/{studentId}/enroll/{courseId}")
    public String enrollCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        studentService.enrollStudentInCourse(studentId, courseId);
        return "redirect:/Home?userName=" + studentService.getStudentById(studentId).getUserName();
    }

    @PostMapping("/{studentId}/drop/{courseId}")
    public String dropCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        studentService.dropCourse(studentId, courseId);

        Student student = studentService.getStudentById(studentId);
        if (student == null) {
            return "redirect:/Login"; // If student is null, redirect to login
        }

        return "redirect:/Home?userName=" + student.getUserName();
    }
}
