package com.example.tbproject.service.impl;

import com.example.tbproject.model.ImageUpload;
import com.example.tbproject.model.ImageUpload2;
import com.example.tbproject.repository.ImageUploadRepository;
import com.example.tbproject.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImageUploadServiceImpl {
    @Autowired
    private ImageUploadRepository imageUploadRepository;

    public String saveImage(String filename, MultipartFile file) throws IOException {
        byte[] imageData = ImageUtils.compressImage(file.getBytes());
        ImageUpload imageUpload1 = new ImageUpload();
        imageUpload1.setFilename(filename);
        imageUpload1.setImage(imageData);

        imageUploadRepository.save(imageUpload1);

        if (imageUpload1 != null){

            return "file uploaded successfully: "+file.getOriginalFilename()+" "+filename;
        }
        return null;
    }

    public byte[] downloadImage(String filename){
        Optional<ImageUpload> imageUpload = imageUploadRepository.findByFilename(filename);
        byte[] images = ImageUtils.decompressImage(imageUpload.get().getImage());
        return  images;
    }
    public ResponseEntity<ImageUpload2> geAllImage() throws IOException{
        ImageUpload img1 = (ImageUpload) imageUploadRepository.findAll();
        String filename = img1.getFilename();
        byte[] img = ImageUtils.decompressImage(img1.getImage());
        ImageUpload2 imgDTO = new ImageUpload2();
        imgDTO.setFilenameDTO(filename);
        imgDTO.setImageDTO(img);

        return new ResponseEntity<ImageUpload2>(imgDTO,HttpStatus.OK);
    }
}
