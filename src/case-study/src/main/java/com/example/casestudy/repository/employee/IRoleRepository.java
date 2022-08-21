package com.example.casestudy.repository.employee;

import com.example.casestudy.model.employee.RoleApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IRoleRepository extends JpaRepository<RoleApp, Integer> {
    @Query(value = "select role_id from user_role", nativeQuery= true)
    List<RoleApp> findRole();
}
