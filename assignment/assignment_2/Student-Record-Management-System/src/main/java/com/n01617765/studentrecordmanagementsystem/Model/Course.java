package com.n01617765.studentrecordmanagementsystem.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;
    @Column(nullable = false)
    private String courseName;

    @Column(nullable = false)
    private String courseDescription;
    @Column(nullable = false)
    private String courseCode;
    // ✅ Constructor matching your CourseService initialization
//    public Course(Long courseId, String courseName,String courseDescription,String courseCode ) {
//        this.courseId = courseId;
//        this.courseCode = courseCode;
//        this.courseName = courseName;
//        this.courseDescription = courseDescription;
//    }

   // @ManyToMany(mappedBy = "courses") // No need for JoinTable here
    //private Set<Student> students = new HashSet<>();




}
