package com.example.casestudy.service.employee.impl;

import com.example.casestudy.model.employee.Degree;
import com.example.casestudy.repository.employee.IDegreeRepository;
import com.example.casestudy.service.employee.IDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DegreeService implements IDegreeService {
    @Autowired
    private IDegreeRepository iDegreeRepository;

    @Override
    public List<Degree> findAll() {
        return iDegreeRepository.findAll();
    }
}
