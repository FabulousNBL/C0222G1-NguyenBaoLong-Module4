package com.example.casestudy.service.contract;

import com.example.casestudy.model.contract.AttachService;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachService {
    List<AttachService> findAll();

    List<Integer> attachId (int id);

    AttachService findById(@Param("id") int id);

    void save(AttachService attachService);
}
