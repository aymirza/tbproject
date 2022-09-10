package com.example.tbproject.controller;

import com.example.tbproject.model.Employees;
import com.example.tbproject.service.EmployeesService;
import com.example.tbproject.service.EmployeesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.DataTruncation;
import java.util.List;

@RestController
@RequestMapping(value = "/api/empl")
public class EmployeeController {

    @Autowired
    private EmployeesService employeesService;

   @PostMapping(consumes = "application/json", path = "/",produces = "application/json")
    public ResponseEntity<Employees> createEmpl(@RequestBody Employees employees){
       return new ResponseEntity<>(employeesService.createEmpl(employees), HttpStatus.CREATED);
   }
   @GetMapping(path = "/{empid}")
    public ResponseEntity<Employees> geEmpl(@PathVariable(value = "empid")Integer empid){
       return new ResponseEntity<>(employeesService.getEmployes(empid),HttpStatus.OK);
   }
   @GetMapping(path = "/allempl",consumes = "application/json",produces = "application/json")
    public ResponseEntity<List<Employees>> getAllEmpl(){
       return new ResponseEntity<>(employeesService.getAllEmpl(),HttpStatus.OK);
   }
   @PutMapping(path = "/update/{empid}",consumes = "application/json",produces = "application/json")
    public ResponseEntity<Employees> updateEmpl(@RequestBody Employees employees ){
       return new ResponseEntity<>(employeesService.updateEmpl(employees),HttpStatus.CREATED);
   }
   @DeleteMapping(path = "/deleteempl",consumes = "application/json",produces = "application/json")
    public ResponseEntity<String> deleteEmpl(@PathVariable(value = "empid") Integer empid){
       employeesService.deleteEmp(empid);
       return new ResponseEntity<>("Employee with EmployeeId: "+empid+" deleted successfully",HttpStatus.OK);
   }








}

