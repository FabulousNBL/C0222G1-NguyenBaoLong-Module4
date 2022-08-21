package com.example.casestudy.repository.customer;

import com.example.casestudy.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType,Integer> {
    List<CustomerType> findAll();
}
