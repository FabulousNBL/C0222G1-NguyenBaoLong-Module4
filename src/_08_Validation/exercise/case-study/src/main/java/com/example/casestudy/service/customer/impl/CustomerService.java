package com.example.casestudy.service.customer.impl;

import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.repository.customer.ICustomerRepository;
import com.example.casestudy.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAllCustomer(Pageable pageable) {
        return iCustomerRepository.findAllCustomer(pageable);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void create(String code, String name, String birthday, int gender, String idCard, String phone, String email, String address, int type) {
        iCustomerRepository.create(code, name, birthday, gender, idCard, phone, email, address, type);
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public Page<Customer> findByName(String name, Pageable pageable) {
        return iCustomerRepository.findAllByNameContaining(name,pageable);
    }
}
