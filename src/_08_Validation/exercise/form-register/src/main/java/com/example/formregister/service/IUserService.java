package com.example.formregister.service;

import com.example.formregister.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserService {

    Page<User> findAllUser(Pageable pageable);

    void create ( String ho,
                  String ten,
                  String phone,
                  int age,
                  String email);
}
