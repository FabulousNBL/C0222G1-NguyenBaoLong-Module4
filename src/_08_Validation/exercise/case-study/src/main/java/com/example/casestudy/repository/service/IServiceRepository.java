package com.example.casestudy.repository.service;

import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IServiceRepository extends JpaRepository<Service, Integer> {

    @Query(value = "select * from service where status = 0", nativeQuery = true)
    Page<Service> findAllService(Pageable pageable);

    @Query(value = "select * from service where id = :id", nativeQuery = true)
    Service findById(@Param("id") int id);



}
