package com.example.formregister.service.impl;

import com.example.formregister.model.User;
import com.example.formregister.repository.IUserRepository;
import com.example.formregister.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;


    @Override
    public Page<User> findAllUser(Pageable pageable) {
        return iUserRepository.findAllUser(pageable);
    }

    @Override
    public void create(String ho, String ten, String phone,int age, String email) {
        iUserRepository.create(ho, ten, phone,age, email);
    }
}
