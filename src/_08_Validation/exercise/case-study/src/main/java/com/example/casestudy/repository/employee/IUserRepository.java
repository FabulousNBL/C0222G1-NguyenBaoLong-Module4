package com.example.casestudy.repository.employee;

import com.example.casestudy.model.employee.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface IUserRepository extends JpaRepository<User, String> {

}
