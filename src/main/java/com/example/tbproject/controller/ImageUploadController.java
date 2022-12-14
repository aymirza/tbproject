package com.example.tbproject.controller;

import com.example.tbproject.model.ImageUpload;
import com.example.tbproject.service.impl.ImageUploadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;


//@CrossOrigin(origins = "http://localhost:4040")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/image")
public class ImageUploadController {

    @Autowired
    private ImageUploadServiceImpl imageUploadService;

    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("filename") String filename,
                                         @RequestParam("image") MultipartFile file) throws IOException{
        String uploadImage = imageUploadService.saveImage(filename,file);
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
    @GetMapping("/get-img-u")
    public ResponseEntity<?> getAllImg()  {
        ResponseEntity<?> imageData2 = imageUploadService.geAllImage();
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData2);
    }
    @GetMapping("")
    public List<ImageUpload> getAllImage(){
        return null;

    }



    @PostMapping("/img-uchastka")
    public ResponseEntity<?>  saveImgU(@RequestParam("filename") String filename,
                                                 @RequestParam("image") MultipartFile file,
                                                 @RequestParam("uchastka") String uchastka
                                                    ) throws IOException{

        String uploadImage = imageUploadService.saveImagee(filename,file,uchastka);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);

    }




}
