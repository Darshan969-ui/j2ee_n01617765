package com.n01617765.studentrecordmanagementsystem.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

@Table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false, unique = true, length = 100)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phone;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;


    // Set default values before persisting to the database
    @PrePersist
    protected void onCreate() {
        createdDate = new Date();
        modifiedDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        modifiedDate = new Date();
    }

//
//    @ManyToMany
//    @JoinTable(
//            name = "student_course", // Join Table Name
//            joinColumns = @JoinColumn(name = "student_id"), // FK for Student
//            inverseJoinColumns = @JoinColumn(name = "course_id") // FK for Course
//    )
//    private Set<Course> courses = new HashSet<>();

    // Instead of @ManyToMany, just store course IDs as a String
    private String enrolledCourseIds;  // Example: "1,2,3"

    // Getter and Setter
    public List<Long> getEnrolledCourseIds() {
        if (enrolledCourseIds == null || enrolledCourseIds.isEmpty()) {
            return new ArrayList<>();
        }
        return Arrays.stream(enrolledCourseIds.split(","))
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }

    public void setEnrolledCourseIds(List<Long> courseIds) {
        this.enrolledCourseIds = courseIds.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }


}
