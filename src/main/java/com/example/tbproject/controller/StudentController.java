package com.example.tbproject.controller;


import com.example.tbproject.model.Student;
import com.example.tbproject.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentsService studentsService;

    @GetMapping("")
    public List<Student> getAllStudents(){
        return studentsService.getAllStudents();
    }

    @PostMapping("/create-student")
    public Student createStudent(@RequestBody Student student){
        return  studentsService.createStudent(student);
    }
    @DeleteMapping("/delete-student/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentsService.deleteStudent(id);
    }


}
