package com.example.tbproject.model;

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

    private String lastname;
    private String firstname;
    private Integer phone;
    @Lob
    @Column(name = "photo", length = 1000)
    private Byte[] photo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_uchastka")
    @JsonManagedReference
    private Uchastka uchastka;





}
