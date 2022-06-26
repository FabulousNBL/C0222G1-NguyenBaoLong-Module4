package com.example.casestudy.service.business.impl;

import com.example.casestudy.model.service.RentType;
import com.example.casestudy.repository.service.IRentTypeRepository;
import com.example.casestudy.service.business.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository iRentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return iRentTypeRepository.findAll();
    }
}
