package com.example.tbproject.service.impl;

import com.example.tbproject.model.Uchastka;
import com.example.tbproject.repository.UchastkaRepository;
import com.example.tbproject.service.UchastkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UchastkaServiceImpl implements UchastkaService {
    @Autowired
    private UchastkaRepository uchastkaRepository;
    @Override
    public List<Uchastka> getAllUchastka() {
        return uchastkaRepository.findAll();
    }
}
