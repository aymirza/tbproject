package com.example.tbproject.service;

import com.example.tbproject.model.TsexUchastkiList;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TsexUchastkiService {
    List<TsexUchastkiList> getAllTsexUchastkiList();
        }
