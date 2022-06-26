package com.example.casestudy.service.business;

import com.example.casestudy.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IService {
    Page<Service> findAllService(Pageable pageable);

    void create(Service service);
}
