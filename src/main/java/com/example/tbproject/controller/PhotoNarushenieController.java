package com.example.tbproject.controller;

import com.example.tbproject.model.PhotoNarushenie;
import com.example.tbproject.service.PhotoNaruhseniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/photo-narushenie")
public class PhotoNarushenieController {
    @Autowired
    private PhotoNaruhseniService photoNaruhseniService;

    @PostMapping
    public ResponseEntity<?> uploadPhoto(@RequestParam("image")MultipartFile file) throws IOException{
        String uploadPhoto = photoNaruhseniService.savePhotoNarushenie(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadPhoto);
    }

    @GetMapping("/{cdate}")
    public ResponseEntity<?>  getPhoto(@PathVariable String cdate) throws ParseException {
        byte[] imgData = photoNaruhseniService.findPhoto(cdate);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imgData);
    }
}
