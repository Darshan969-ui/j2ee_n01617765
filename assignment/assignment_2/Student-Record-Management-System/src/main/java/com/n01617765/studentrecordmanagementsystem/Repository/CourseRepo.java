package com.n01617765.studentrecordmanagementsystem.Repository;

import com.n01617765.studentrecordmanagementsystem.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepo extends JpaRepository<Course,Long> {
    List<Course> findAll();
    Optional<Course> findByCourseCode(String courseCode); // Find course by code
}
