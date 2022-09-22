package com.example.tbproject.service.impl;

import com.example.tbproject.model.NarushenieList;
import com.example.tbproject.repository.NarushenieListRepository;
import com.example.tbproject.service.NarushenieListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NarushenieListServiceImpl implements NarushenieListService {
    @Autowired
    private NarushenieListRepository narushenieListRepository;

    @Override
    public List<NarushenieList> getAllNarusheniList() {
        return narushenieListRepository.findAll();
    }
}
