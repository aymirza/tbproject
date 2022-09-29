package com.example.tbproject.model;

import com.example.tbproject.service.PhotoNaruhseniService;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empid;
    private String name;
    private String uchastka;
    @OneToOne
    @JoinColumn(name = "photo_id")
    private PhotoNarushenie photoNarushenie;

    public Employees(EmployeesDTO employeesDTO){
        this.name = employeesDTO.getName();
        this.uchastka = employeesDTO.getUchastka();
        this.photoNarushenie = employeesDTO.getPhotoNarushenie();

    }





}
