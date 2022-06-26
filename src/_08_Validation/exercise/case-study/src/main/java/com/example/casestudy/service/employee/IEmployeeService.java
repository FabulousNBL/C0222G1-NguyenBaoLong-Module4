package com.example.casestudy.service.employee;

import com.example.casestudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IEmployeeService {
    Page<Employee> findAllEmployee(Pageable pageable);

    void create (Employee employee);

    Employee findById(int id);
}
