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
@Table(name = "narushenie_list")
public class NarushenieList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer narushenie_list_id;

    private String name;

}
