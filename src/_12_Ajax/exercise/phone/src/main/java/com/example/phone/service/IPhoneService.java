package com.example.phone.service;

import com.example.phone.model.Phone;

import java.util.List;

public interface IPhoneService {
    List<Phone> getAll();

    Phone findById(int id);

    Phone save(Phone phone);

    void remove(int id);

    void update(Phone phone);
}
