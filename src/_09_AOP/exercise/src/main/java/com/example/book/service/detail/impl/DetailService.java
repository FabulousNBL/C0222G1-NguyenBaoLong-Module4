package com.example.book.service.detail.impl;

import com.example.book.model.Detail;
import com.example.book.repository.IDetailRepository;
import com.example.book.service.detail.IDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DetailService implements IDetailService {
    @Autowired
    private IDetailRepository iDetailRepository;

    @Override
    public Detail findById(String id) {
        return iDetailRepository.findById(id);
    }

    @Override
    public void delete(Detail detail) {
        iDetailRepository.delete(detail);
    }



    @Override
    public void save(Detail detail) {
        iDetailRepository.save(detail);
    }
}
