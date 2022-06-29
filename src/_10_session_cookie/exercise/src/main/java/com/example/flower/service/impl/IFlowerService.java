package com.example.flower.service.impl;

import com.example.flower.model.Flower;

import java.util.List;

public interface IFlowerService {
    Flower findById(int id);

    List<Flower> getAll();
}
