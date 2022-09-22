package com.example.tbproject.service;

import com.example.tbproject.model.NarushenieList;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface NarushenieListService {
    List<NarushenieList> getAllNarusheniList();
}
