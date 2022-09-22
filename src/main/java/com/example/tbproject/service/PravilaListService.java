package com.example.tbproject.service;

import com.example.tbproject.model.PravilaList;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PravilaListService {
    List<PravilaList> getAllPravilaList();

}
