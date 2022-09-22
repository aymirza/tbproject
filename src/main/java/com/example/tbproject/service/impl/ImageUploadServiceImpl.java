package com.example.tbproject.service.impl;

import com.example.tbproject.model.ImageUpload;
import com.example.tbproject.repository.ImageUploadRepository;
import com.example.tbproject.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImageUploadServiceImpl {
    @Autowired
    private ImageUploadRepository imageUploadRepository;

    public String saveImage(MultipartFile file) throws IOException {
        ImageUpload imageUpload = imageUploadRepository.save(ImageUpload.builder()
                .filename(file.getOriginalFilename())

                .image(ImageUtils.compressImage(file.getBytes())).build());
        if (imageUpload != null){
            return "file uploaded successfully: "+file.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadImage(String filename){
        Optional<ImageUpload> imageUpload = imageUploadRepository.findByFilename(filename);
        byte[] images = ImageUtils.decompressImage(imageUpload.get().getImage());
        return  images;
    }
}
