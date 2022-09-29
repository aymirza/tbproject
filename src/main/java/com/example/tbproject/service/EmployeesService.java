package com.example.tbproject.service;

import com.example.tbproject.model.Employees;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
public interface EmployeesService {
    Employees createEmpl(String name, MultipartFile file) throws IOException;

    Employees updateEmpl(Employees employees);

    Employees getEmployes(Integer empid);

    void deleteEmp(Integer empid);

    List<Employees> getAllEmpl();


}
