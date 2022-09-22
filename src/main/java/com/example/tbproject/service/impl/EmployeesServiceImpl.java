package com.example.tbproject.service.impl;

import com.example.tbproject.model.Employees;
import com.example.tbproject.model.Uchastka;
import com.example.tbproject.repository.EmployeesRepository;
import com.example.tbproject.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    @Autowired
    private EmployeesRepository employeesRepository;

    @Override
    public Employees createEmpl(Employees employees) {
        return employeesRepository.save(employees);
    }

    @Override
    public Employees updateEmpl(Employees employees) {
        return employeesRepository.save(employees);
    }

    @Override
    public Employees getEmployes(Integer empid) {
        Optional<Employees> optionalEmployees = employeesRepository.findById(empid);
        if (optionalEmployees.isPresent()){
            return optionalEmployees.get();
        }
        return null;
    }

    @Override
    public void deleteEmp(Integer empid) {
        employeesRepository.findByEmpid(empid);
    }

    @Override
    public List<Employees> getAllEmpl() {
        return employeesRepository.findAll();
    }
}
