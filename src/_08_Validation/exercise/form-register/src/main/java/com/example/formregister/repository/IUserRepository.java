package com.example.formregister.repository;

import com.example.formregister.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IUserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from user where status = 0", nativeQuery = true)
    Page<User> findAllUser(Pageable pageable);

    @Modifying
    @Query(value = "insert into user (last_name, first_name, phone,age, email) values (:ho, :ten, :phone,:age, :email)",nativeQuery = true)
    void create (@Param("ho") String ho,
                 @Param("ten") String ten,
                 @Param("phone") String phone,
                 @Param("age") int age,
                 @Param("email") String email);


}
