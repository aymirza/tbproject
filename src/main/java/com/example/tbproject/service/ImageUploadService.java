package com.example.tbproject.service;

import com.example.tbproject.model.ImageUpload;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
public interface ImageUploadService {
    ImageUpload saveImage(MultipartFile file) throws IOException;
    ImageUpload getImage(Long id);
    List<ImageUpload> getAllImages();

}
