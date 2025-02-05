package com.n01617765.studentdataapplication.Controller;
import  com.n01617765.studentdataapplication.Entity.Student;
import com.n01617765.studentdataapplication.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/")
    public String studentMainPage(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "StudentManagement";
    }
    @GetMapping("/AddStudent")
    public String AddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "AddStudent";
    }
    @PostMapping("/AddStudent")
    public String addStudent(@ModelAttribute("student") Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "AddStudent";
        }
        studentService.addStudent(student);
        return "redirect:/";
    }

}
