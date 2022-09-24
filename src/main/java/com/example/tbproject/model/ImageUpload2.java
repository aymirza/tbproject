package com.example.tbproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageUpload2 {


    private String filenameDTO;

    private byte[] imageDTO;
}
