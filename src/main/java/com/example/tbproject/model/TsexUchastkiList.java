package com.example.tbproject.model;

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
@Table(name = "tsex_uchastka_list")
public class TsexUchastkiList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tsex_uchastka_list_id;

    private String name;
}
