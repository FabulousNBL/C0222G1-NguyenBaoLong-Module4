package com.example.casestudy.service.employee.impl;

import com.example.casestudy.model.employee.Employee;
import com.example.casestudy.repository.employee.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements com.example.casestudy.service.employee.IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public Page<Employee> findAllEmployee(Pageable pageable) {
        return iEmployeeRepository.findAllEmployee(pageable);
    }


    @Override
    public void create(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return iEmployeeRepository.findById(id);
    }
}
