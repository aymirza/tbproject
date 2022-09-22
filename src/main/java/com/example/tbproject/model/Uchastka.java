package com.example.tbproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "uchastka")
public class Uchastka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uchastka_id;

    private String name;



}
