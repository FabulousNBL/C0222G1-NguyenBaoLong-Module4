package com.example.casestudy.service.customer;

import com.example.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface ICustomerService {
    Page<Customer> findAllCustomer(Pageable pageable);

    void save(Customer customer);

    void create ( String code,
                  String name,
                  String birthday,
                  int gender,
                  String idCard,
                  String phone,
                  String email,
                  String address,
                  int type);

    Customer findById(int id);




}
