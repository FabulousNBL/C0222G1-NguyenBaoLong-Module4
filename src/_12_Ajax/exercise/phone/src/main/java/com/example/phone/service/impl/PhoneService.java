package com.example.phone.service.impl;

import com.example.phone.model.Phone;
import com.example.phone.repository.IPhoneRepository;
import com.example.phone.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService implements IPhoneService {
    @Autowired
    private IPhoneRepository iPhoneRepository;


    @Override
    public List<Phone> getAll() {
        return iPhoneRepository.findAll();
    }

    @Override
    public Phone findById(int id) {
        return iPhoneRepository.findById(id).orElse(null);
    }

    @Override
    public Phone save(Phone phone) {
        return iPhoneRepository.save(phone);
    }

    @Override
    public void remove(int id) {
        iPhoneRepository.deleteById(id);
    }

    @Override
    public void update(Phone phone) {
        iPhoneRepository.save(phone);
    }
}
