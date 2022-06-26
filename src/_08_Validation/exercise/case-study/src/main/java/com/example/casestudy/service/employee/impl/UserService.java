package com.example.casestudy.service.employee.impl;

import com.example.casestudy.model.employee.User;
import com.example.casestudy.repository.employee.IUserRepository;
import com.example.casestudy.service.employee.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public void create(User user) {
        iUserRepository.save(user);
    }
}
