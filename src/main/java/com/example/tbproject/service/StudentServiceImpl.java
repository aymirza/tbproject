package com.example.tbproject.service;

import com.example.tbproject.model.Student;
import com.example.tbproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentsService{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.getReferenceById(id);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);

    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
