package com.example.casestudy.repository.service;

import com.example.casestudy.model.customer.CustomerType;
import com.example.casestudy.model.service.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IRentTypeRepository extends JpaRepository<RentType, Integer> {
    List<RentType> findAll();
}
