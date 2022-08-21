package com.example.casestudy.service.business.impl;

import com.example.casestudy.model.service.ServiceType;
import com.example.casestudy.repository.service.ITypeServiceRepository;
import com.example.casestudy.service.business.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeService implements ITypeService {
    @Autowired
    private ITypeServiceRepository iTypeServiceRepository;

    @Override
    public List<ServiceType> findAll() {
        return iTypeServiceRepository.findAll();
    }
}
