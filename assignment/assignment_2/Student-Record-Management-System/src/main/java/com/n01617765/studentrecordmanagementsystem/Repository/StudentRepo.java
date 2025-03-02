package com.n01617765.studentrecordmanagementsystem.Repository;

import com.n01617765.studentrecordmanagementsystem.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    List<Student> findByUserName(String userName);
}
