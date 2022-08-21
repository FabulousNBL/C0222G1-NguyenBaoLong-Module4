package com.example.demo.service.impl;

import com.example.demo.model.BenhAn;
import com.example.demo.repository.BenhAnRepository;
import com.example.demo.service.IBenhAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service(value = "benhAn")
public class BenhAnService implements IBenhAnService {
    @Autowired
    private BenhAnRepository benhAnRepository;


    @Override
    public Page<BenhAn> findAll(Pageable pageable) {
        return benhAnRepository.findAll(pageable);
    }

    @Override
    public BenhAn save(BenhAn benhAn) {
        return benhAnRepository.save(benhAn);
    }

    @Override
    public Iterable<BenhAn> showAll() {
        return benhAnRepository.findAll();
    }

    @Override
    public Optional<BenhAn> findById(String id) {
        return benhAnRepository.findById(id);
    }

    @Override
    public void remove(String id) {
        benhAnRepository.deleteById(id);
    }


}
