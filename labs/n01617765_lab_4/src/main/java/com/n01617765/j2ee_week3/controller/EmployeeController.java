    package com.n01617765.j2ee_week3.controller;

    import com.n01617765.j2ee_week3.model.Employee;
    import com.n01617765.j2ee_week3.service.EmployeeService;
    import jakarta.validation.Valid;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.validation.BindingResult;
    import org.springframework.validation.annotation.Validated;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;

    import java.util.List;

    @Controller
    public class EmployeeController {

        private final EmployeeService employeeService;

        @Autowired
        public EmployeeController(EmployeeService employeeService) {

            this.employeeService = employeeService;
        }

        @GetMapping("/")
        public String listEmployees(Model model) {
            model.addAttribute("employees", employeeService.getAllEmployees());
            model.addAttribute("addoneEmployee", new Employee());
            return "employees";
        }
// I wanted to check if the messages are being printed to the console
        private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

        @PostMapping("/addEmployee")
        public String addEmployee(@Valid @ModelAttribute("addoneEmployee") Employee employee, BindingResult result, Model model) {
            if (result.hasErrors()) {
                model.addAttribute("addoneEmployee", employee);  // Pass the object with validation errors
                return "employees";  // Re-render the form with validation errors
            }
            employeeService.addEmployee(employee);
            return "redirect:/";  // Redirect after successful submission
        }


        @PostMapping("/updateEmployee")
        public String updateEmployee(@ModelAttribute Employee employee) {
            employeeService.updateEmployee(employee);
            return "redirect:/";
        }

        @GetMapping("/delete/{id}")
        public String deleteEmployee(@PathVariable Integer id) {
            employeeService.deleteEmployee(id);
            return "redirect:/";
        }



        @GetMapping("/search")
        public String searchEmployee(@RequestParam Integer id, Model model) {
            Employee employee = employeeService.getEmployeeById(id);
            if (employee != null) {
                model.addAttribute("employees", List.of(employee)); // Show only the searched employee
            } else {
                model.addAttribute("employees", employeeService.getAllEmployees()); // Show all if not found
            }
            model.addAttribute("addoneEmployee", new Employee()); // Keep form visible
            return "employees";
        }


    }
