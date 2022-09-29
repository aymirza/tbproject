package com.example.tbproject.service.impl;

import com.example.tbproject.model.PhotoNarushenie;
import com.example.tbproject.repository.PhotoNarushenieRepository;
import com.example.tbproject.service.PhotoNaruhseniService;
import com.example.tbproject.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Service
public class PhotoNarusheniServiceImpl implements PhotoNaruhseniService {
    @Autowired
    private PhotoNarushenieRepository photoNarushenieRepository;

    @Override
    public String savePhotoNarushenie(MultipartFile file) throws IOException {
        byte[] imagData = ImageUtils.compressImage(file.getBytes());
        PhotoNarushenie photoNarushenie = new PhotoNarushenie();
        photoNarushenie.setCdate(String.valueOf(LocalDate.now()));
        photoNarushenie.setPhoto(imagData);
        photoNarushenieRepository.save(photoNarushenie);
        if (photoNarushenie != null){
            return "file saved"+file.getOriginalFilename();
        }
        return null;

    }


    @Override
    public byte[] findPhoto(String cdate) {
        Optional<PhotoNarushenie> photoNarushenie = photoNarushenieRepository
                .findByCdate(cdate);
        byte[] img= ImageUtils.decompressImage(photoNarushenie.get().getPhoto());
        return img;
    }


}
