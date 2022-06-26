package com.example.casestudy.repository.customer;

import com.example.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from customer where status = 0", nativeQuery = true)
    Page<Customer> findAllCustomer(Pageable pageable);

    @Modifying
    @Query(value = "insert into customer (code_customer, name, birthday, gender, customer_id_card, phone, email, address,type_id)" +
            "values (:code, :name, :birthday, :gender, :idCard, :phone, :email, :address, :type)",nativeQuery = true )
    void create (@Param("code") String code,
                 @Param("name") String name,
                 @Param("birthday") String birthday,
                 @Param("gender") int gender,
                 @Param("idCard") String idCard,
                 @Param("phone") String phone,
                 @Param("email") String email,
                 @Param("address") String address,
                 @Param("type") int type);

    @Query(value = "select * from customer where id = :id", nativeQuery = true)
    Customer findById(@Param("id") int id);
}
