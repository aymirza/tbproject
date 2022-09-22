package com.example.tbproject.service.impl;

import com.example.tbproject.model.PravilaList;
import com.example.tbproject.repository.PravilaListRepository;
import com.example.tbproject.service.PravilaListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PravilaListServiceImpl implements PravilaListService {

    @Autowired
    private PravilaListRepository pravilaListRepository;

    @Override
    public List<PravilaList> getAllPravilaList() {
        return pravilaListRepository.findAll();
    }
}
