package com.example.casestudy.service.employee;

import com.example.casestudy.model.employee.UserApp;

import java.util.List;

public interface IUserService {
    List<UserApp> findAll();

    void create (UserApp userApp);


}
