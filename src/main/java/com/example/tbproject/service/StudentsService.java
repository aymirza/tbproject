package com.example.tbproject.service;

import com.example.tbproject.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentsService {
    Student createStudent(Student student);
    Student updateStudent(Student student);
    Student getStudent(Long id);
    void deleteStudent(Long id);
    List<Student> getAllStudents();
}
