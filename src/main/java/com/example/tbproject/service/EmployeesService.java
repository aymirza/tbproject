package com.example.tbproject.service;

import com.example.tbproject.model.Employees;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeesService {
    Employees createEmpl(Employees employees);

    Employees updateEmpl(Employees employees);

    Employees getEmployes(Integer empid);

    void deleteEmp(Integer empid);

    List<Employees> getAllEmpl();


}
