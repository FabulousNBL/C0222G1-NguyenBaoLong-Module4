package com.example.demo.service.impl;

import com.example.demo.model.BenhNhan;
import com.example.demo.repository.BenhNhanRepository;
import com.example.demo.service.IBenhNhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("benhNhan")
public class BenhNhanService implements IBenhNhanService {
    @Autowired
    private BenhNhanRepository benhNhanRepository;


    @Override
    public List<BenhNhan> findAll() {
        return benhNhanRepository.findAll();
    }
}
