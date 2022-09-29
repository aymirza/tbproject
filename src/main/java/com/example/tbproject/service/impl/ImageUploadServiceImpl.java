package com.example.tbproject.service.impl;

import com.example.tbproject.model.ImageUchastka;
import com.example.tbproject.model.ImageUpload;
import com.example.tbproject.model.Uchastka;
import com.example.tbproject.repository.ImageUploadRepository;
import com.example.tbproject.repository.UchastkaRepository;
import com.example.tbproject.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageUploadServiceImpl {
    @Autowired
    private ImageUploadRepository imageUploadRepository;
    @Autowired
    private UchastkaRepository uchastkaRepository;

    public String saveImage(String filename, MultipartFile file) throws IOException {
        byte[] imageData = ImageUtils.compressImage(file.getBytes());
        ImageUpload imageUpload1 = new ImageUpload();
        imageUpload1.setFilename(filename);
        imageUpload1.setImage(imageData);

        imageUploadRepository.save(imageUpload1);

        if (imageUpload1 != null) {

            return "file uploaded successfully: " + file.getOriginalFilename() + " " + filename;
        }
        return null;
    }

    public String saveImagee(String filename, MultipartFile file, String uchastka) throws IOException {

        Uchastka uchastka1 = new Uchastka();
        uchastka1.setName(uchastka);
        uchastka1 = uchastkaRepository.save(uchastka1);

        byte[] imageData = ImageUtils.compressImage(file.getBytes());
        ImageUpload imageUpload1 = new ImageUpload();
        imageUpload1.setFilename(filename);
        imageUpload1.setImage(imageData);
        imageUpload1.setUchastka(uchastka1);

        imageUploadRepository.save(imageUpload1);

        if (imageUpload1 != null) {

            return "file uploaded successfully: " + file.getOriginalFilename() + " " + filename;
        }
        return null;
    }

    public byte[] downloadImage(String filename) {
        Optional<ImageUpload> imageUpload = imageUploadRepository.findByFilename(filename);
        byte[] images = ImageUtils.decompressImage(imageUpload.get().getImage());
        return images;
    }

    public ResponseEntity<?> geAllImage() {

        ImageUpload img1 = (ImageUpload) imageUploadRepository.findAll();
        String filename = img1.getFilename();
        Uchastka uchastka = img1.getUchastka();
        byte[] img = ImageUtils.decompressImage(img1.getImage());
        ImageUchastka imgU = new ImageUchastka();
        imgU.setFilename(filename);
        imgU.setImage(img);
        imgU.setUchastka(String.valueOf(uchastka));

        return new ResponseEntity<>(imgU, HttpStatus.OK);
    }
}
