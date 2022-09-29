package com.example.tbproject.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "photo_narushenie")
public class PhotoNarushenie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long photo_id;
    @Lob
    @Column(name = "image", length = 1000)
    private byte[] photo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "cdate")
    private String cdate;



}

