package com.example.tbproject.controller;

import com.example.tbproject.service.ImageUploadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


//@CrossOrigin(origins = "http://localhost:4040")
@RestController
@RequestMapping("/api/image")
public class ImageUploadController {

    @Autowired
    private ImageUploadServiceImpl imageUploadService;

    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException{
        String uploadImage = imageUploadService.saveImage(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }
    @GetMapping("/{filename}")
    public ResponseEntity<?> downloadImage(@PathVariable String filename){
        byte[]  imageData = imageUploadService.downloadImage(filename);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }

}
