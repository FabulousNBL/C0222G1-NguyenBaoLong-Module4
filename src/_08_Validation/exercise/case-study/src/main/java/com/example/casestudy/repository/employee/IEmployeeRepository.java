package com.example.casestudy.repository.employee;

import com.example.casestudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select * from employee where status = 0", nativeQuery = true)
    Page<Employee> findAllEmployee(Pageable pageable);


    @Modifying
    @Query(value = "insert into employee (name, birthday, card_id, salary, phone,email, address, degree_id, division_id, position_id, user_name) values" +
            "(:name, :birthday, :card, :salary, :phone, :email, :address, :degree, :division, :position, :user)", nativeQuery = true)
    void create (@Param("name") String name,
                 @Param("birthday") String birthday,
                 @Param("card") String card,
                 @Param("salary") Double salary,
                 @Param("phone") String phone,
                 @Param("email") String email,
                 @Param("address") String address,
                 @Param("degree") String degree,
                 @Param("division") String division,
                 @Param("position") String position,
                 @Param("user") String user);

    @Query(value = "select * from employee  where id = :id and status =0", nativeQuery= true)
    Employee findById(@Param("id") int id);

}
