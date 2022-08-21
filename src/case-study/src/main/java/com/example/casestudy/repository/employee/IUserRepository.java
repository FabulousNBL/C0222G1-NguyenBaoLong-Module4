package com.example.casestudy.repository.employee;

import com.example.casestudy.model.employee.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;


import javax.transaction.Transactional;

@Transactional
public interface IUserRepository extends JpaRepository<UserApp, String> {

    UserApp findByUserName(String username);
}
