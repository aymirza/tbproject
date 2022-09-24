package com.example.tbproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "narushenie_model")
public class EmployeeNarushenieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empl_narushenie_model_id;
    private String lastname;
    private String firstname;
    private String uchastka;
    private String tsex_uchastka;
    private String pravila;
    private String narushenie;
    //    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_uchastka")
//    @JsonManagedReference
    @Lob
    @Column(name = "image", length = 1000)
    private byte[] image;


}
