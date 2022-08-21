package com.example.demo.service;

import com.example.demo.model.BenhAn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBenhAnService {
    Page<BenhAn> findAll(Pageable pageable);

    BenhAn save(BenhAn benhAn);

    Iterable<BenhAn> showAll();

    Optional<BenhAn> findById(String id);

    void remove(String id);
}
