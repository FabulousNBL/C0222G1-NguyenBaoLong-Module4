package com.example.casestudy.repository.service;

import com.example.casestudy.model.customer.CustomerType;
import com.example.casestudy.model.service.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITypeServiceRepository extends JpaRepository<ServiceType, Integer> {
    List<ServiceType> findAll();
}
