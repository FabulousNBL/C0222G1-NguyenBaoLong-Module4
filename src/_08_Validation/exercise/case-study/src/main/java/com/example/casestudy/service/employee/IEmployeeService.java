package com.example.casestudy.service.employee;

import com.example.casestudy.dto.EmployeeDto;
import com.example.casestudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> findAllEmployee(Pageable pageable);

    void create (Employee employee);

    Employee findById(int id);

    Page<Employee> findByName( String name, Pageable pageable);

}
