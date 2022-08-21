package com.example.casestudy.repository.employee;

import com.example.casestudy.model.employee.Degree;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IDegreeRepository extends JpaRepository<Degree, Integer> {

}
