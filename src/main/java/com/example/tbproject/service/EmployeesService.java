package com.example.tbproject.service;

import com.example.tbproject.model.Employees;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeesService {
    public Employees createEmpl(Employees employees);
    public Employees updateEmpl(Employees employees);
    public Employees getEmployes(Integer empid);
    public void deleteEmp(Integer empid);
    public List<Employees> getAllEmpl();


}
