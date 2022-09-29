package com.example.tbproject.service.impl;

import com.example.tbproject.model.Employees;
import com.example.tbproject.model.PhotoNarushenie;
import com.example.tbproject.repository.EmployeesRepository;
import com.example.tbproject.repository.PhotoNarushenieRepository;
import com.example.tbproject.service.EmployeesService;
import com.example.tbproject.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    @Autowired
    private EmployeesRepository employeesRepository;
    @Autowired
    private PhotoNarushenieRepository photoNarushenieRepository;

    @Override
    public Employees createEmpl(String name, MultipartFile file) throws IOException {
        PhotoNarushenie photoNarushenie = new PhotoNarushenie();
        byte[] imgData = ImageUtils.compressImage(file.getBytes());
        photoNarushenie.setPhoto(imgData);
        photoNarushenie.setCdate(String.valueOf(LocalDate.now()));
        photoNarushenie = photoNarushenieRepository.save(photoNarushenie);

        Employees employees = new Employees();
        employees.setName(name);
        employees.setPhotoNarushenie(photoNarushenie);
        employeesRepository.save(employees);

        return employees;
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
