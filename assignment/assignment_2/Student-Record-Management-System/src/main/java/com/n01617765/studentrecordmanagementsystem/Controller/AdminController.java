package com.n01617765.studentrecordmanagementsystem.Controller;

import com.n01617765.studentrecordmanagementsystem.Model.Student;
import com.n01617765.studentrecordmanagementsystem.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final StudentService studentService;

    @Autowired
    public AdminController(StudentService studentService) {
        this.studentService = studentService;
    }
    // ✅ Show Student Dashboard (Admin View)
    @GetMapping("/students")
    public String showStudentDashboard(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "Admin"; // ✅ This must match "adminStudentDashboard.html"
    }
    // ✅ Show Edit Student Form
    @GetMapping("/students/edit/{id}")
    public String showEditStudentForm(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "editStudent"; // ✅ This must match "editStudent.html"
    }
    // ✅ Handle Student Update by Admin
    @PostMapping("/students/update")
    public String updateStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "editStudent"; // ✅ Return form with errors
        }
        studentService.updateStudent(student.getStudentId(), student);
        return "redirect:/admin/students"; // ✅ Redirect to student list
    }
    // ✅ Handle Student Deletion by Admin
    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/admin/students";
    }
}
