package com.example.flower.service.impl;

import com.example.flower.model.Flower;
import com.example.flower.repository.IFlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowerService implements IFlowerService {
    @Autowired
    private IFlowerRepository iFlowerRepository;


    @Override
    public Flower findById(int id) {
        return iFlowerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Flower> getAll() {
        return iFlowerRepository.findAll();
    }


}
