package com.example.tbproject.service;

import com.example.tbproject.model.PhotoNarushenie;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Component
public interface PhotoNaruhseniService {

    String savePhotoNarushenie(MultipartFile file) throws IOException;



    byte[] findPhoto(String cdate);
}
