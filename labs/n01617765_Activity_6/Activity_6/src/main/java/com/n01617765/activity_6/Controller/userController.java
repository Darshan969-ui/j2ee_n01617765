package com.n01617765.activity_6.Controller;

import com.n01617765.activity_6.Model.User;
import com.n01617765.activity_6.Service.userService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class userController {  // Fixed class name

    private final userService userService;  // Fixed naming convention

    @Autowired
    public userController(userService userService) {
        this.userService = userService;
    }

    // Show Sign Up Page
    @GetMapping("/addUser")
    public String showAddUserForm(Model model) {
        model.addAttribute("addNewUser", new User());  // Initialize empty form
        return "Sign_up";  // Ensure there is a signup.html
    }

    // Add a New User
    @PostMapping("/addUser")
    public String addUser(@Valid @ModelAttribute("addNewUser") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("addNewUser", user);  // Pass the object with validation errors
            return "Sign_up"; // Re-render the form with validation errors
        }
        userService.addUser(user);
        return "redirect:/Login"; // Redirect to login page after successful sign-up
    }

    // Show Login Page
    @GetMapping("/Login")
    public String showLoginPage() {
        return "Login";  // Ensure there is a login.html
    }

    // User Login
    @PostMapping("/loginUser")
    public String loginUser(@RequestParam("userName") String userName, 
                            @RequestParam("password") String password, 
                            Model model) {
        User authenticatedUser = userService.userLogin(userName, password);
        //System.out.println(authenticatedUser.getFirstName());
        
        if (authenticatedUser == null) {
            model.addAttribute("error", "Invalid username or password");
            return "Login"; // Redirect to login page with error message
        }

        model.addAttribute("user", authenticatedUser);
        return "redirect:/Home?userName=" + userName;
        // Redirect to home page upon successful login
    }
    @GetMapping("/Home")
    public String home(@RequestParam("userName") String userName, Model model) {
        User user = userService.userName(userName);

        if (user == null) {
            return "redirect:/Login"; // Redirect to login if user not found
        }

        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("userName", userName); // Ensure userName is passed to Thymeleaf

        return "Home"; // Load Home.html
    }


}
