package com.n01617765.j2ee_week3.model;


import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Size;

@Getter
@Setter
public class Employee {

        private Integer id;

        @NotNull(message = "First Name cannot be empty")
        @Size(min = 5, max = 20, message = "First name must be between 5 and 20 characters")
        private String firstName;

        @NotBlank(message = "Last name cannot be empty")
        private String lastName;

        @NotBlank(message = "Email cannot be empty")
        @Email(message = "Invalid email format")
        private String emailId;

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getEmailId() {
//        return emailId;
//    }
//
//    public void setEmailId(String emailId) {
//        this.emailId = emailId;
//    }
}


