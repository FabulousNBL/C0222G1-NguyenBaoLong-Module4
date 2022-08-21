package com.example.casestudy.service.contract.impl;

import com.example.casestudy.repository.contract.IAttachServiceRepository;
import com.example.casestudy.service.contract.IAttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachService implements IAttachService {
    @Autowired
    private IAttachServiceRepository attachServiceRepository;

    @Override
    public List<com.example.casestudy.model.contract.AttachService> findAll() {
        return attachServiceRepository.findAll();
    }

    @Override
    public List<Integer> attachId(int id) {
        return attachServiceRepository.attachId(id);
    }

    @Override
    public com.example.casestudy.model.contract.AttachService findById(int id) {
        return attachServiceRepository.findById(id);
    }

    @Override
    public void save(com.example.casestudy.model.contract.AttachService attachService) {
        attachServiceRepository.save(attachService);
    }
}
