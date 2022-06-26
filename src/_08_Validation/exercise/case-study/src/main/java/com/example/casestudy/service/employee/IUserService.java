package com.example.casestudy.service.employee;

import com.example.casestudy.model.employee.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void create (User user);
}
