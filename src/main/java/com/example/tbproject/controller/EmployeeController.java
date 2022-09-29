package com.example.tbproject.controller;

import com.example.tbproject.model.Employees;
import com.example.tbproject.model.Uchastka;
import com.example.tbproject.service.EmployeesService;
import com.example.tbproject.service.UchastkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/empl")
public class EmployeeController {

    @Autowired
    private EmployeesService employeesService;
    @Autowired
    private UchastkaService uchastkaService;

    @PostMapping(path = "/create-empl")
    public ResponseEntity<?> createEmpl(@RequestParam("name") String name, @RequestParam("uchastka") String uchastka,
                                        @RequestParam("photo") MultipartFile file) throws IOException {
        Employees employees = employeesService.createEmpl(name, uchastka,file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(employees);
    }

    @GetMapping(path = "/{empid}")
    public ResponseEntity<Employees> getEmpl(@PathVariable(value = "empid") Integer empid) {
        return new ResponseEntity<>(employeesService.getEmployes(empid), HttpStatus.OK);
    }

    @GetMapping(path = "/allempl")
    public ResponseEntity<List<Employees>> getAllEmpl() {
        return new ResponseEntity<>(employeesService.getAllEmpl(), HttpStatus.OK);
    }

    @PutMapping(path = "/update/{empid}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Employees> updateEmpl(@RequestBody Employees employees) {
        return new ResponseEntity<>(employeesService.updateEmpl(employees), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/deleteempl", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> deleteEmpl(@PathVariable(value = "empid") Integer empid) {
        employeesService.deleteEmp(empid);
        return new ResponseEntity<>("Employee with EmployeeId: " + empid + " deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/uchastka")
    public ResponseEntity<List<Uchastka>> getAllUchastki() {
        return new ResponseEntity<>(uchastkaService.getAllUchastka(), HttpStatus.OK);
    }


}

