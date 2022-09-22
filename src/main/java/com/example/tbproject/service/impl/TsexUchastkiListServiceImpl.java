package com.example.tbproject.service.impl;

import com.example.tbproject.model.TsexUchastkiList;
import com.example.tbproject.repository.TsexUchastkiListRepository;
import com.example.tbproject.service.TsexUchastkiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TsexUchastkiListServiceImpl implements TsexUchastkiService {
    @Autowired
    private TsexUchastkiListRepository tsexUchastkiListRepository;

    @Override
    public List<TsexUchastkiList> getAllTsexUchastkiList() {
        return tsexUchastkiListRepository.findAll();
    }
}
