package com.n01617765.studentrecordmanagementsystem.Service;

import com.n01617765.studentrecordmanagementsystem.Model.Course;
import com.n01617765.studentrecordmanagementsystem.Repository.CourseRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepo courseRepo;


    @PostConstruct // Runs this method when the application starts
    public void insertDefaultCourses() {
        List<Course> defaultCourses = List.of(
                new Course(null, "Introduction to Computer Science", "Basic CS concepts", "CS101"),
                new Course(null, "Networking Fundamentals", "Introduction to networks", "IT102"),
                new Course(null, "Database Systems", "SQL and NoSQL databases", "IT103"),
                new Course(null, "Cyber Security Basics", "Understanding cybersecurity threats", "IT104"),
                new Course(null, "Software Engineering", "Software development processes", "IT105")
        );

        for (Course course : defaultCourses) {
            if (courseRepo.findByCourseCode(course.getCourseCode()).isEmpty()) {
                courseRepo.save(course); // Insert only if the course does not exist
            }
        }
        System.out.println("✅ Default courses added!");
    }

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

}
