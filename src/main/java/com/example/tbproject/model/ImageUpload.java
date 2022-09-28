package com.example.tbproject.model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "imgupload")
public class ImageUpload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String filename;
    @Lob
    @Column(name = "image", length = 1000)
    private byte[] image;
    @OneToOne
    @JoinColumn(name = "uchastka_Id")
    private Uchastka uchastka;


    public ImageUpload(ImageUchastka imageUchastka) {
        this.filename = imageUchastka.getFilename();
        this.image = imageUchastka.getImage();
    }
}



