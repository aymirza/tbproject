package com.example.tbproject.service;

import com.example.tbproject.model.Uchastka;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UchastkaService {
    List<Uchastka> getAllUchastka();

}
