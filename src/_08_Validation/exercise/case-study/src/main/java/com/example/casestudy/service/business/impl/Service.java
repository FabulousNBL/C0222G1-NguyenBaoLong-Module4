package com.example.casestudy.service.business.impl;

import com.example.casestudy.repository.service.IServiceRepository;
import com.example.casestudy.service.business.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@org.springframework.stereotype.Service
public class Service implements IService {
    @Autowired
    private IServiceRepository iServiceRepository;

    @Override
    public Page<com.example.casestudy.model.service.Service> findAllService(Pageable pageable) {
        return iServiceRepository.findAllService(pageable);
    }

    @Override
    public void create(com.example.casestudy.model.service.Service service) {
        iServiceRepository.save(service);
    }

}
