package com.example.casestudy.service.employee.impl;

import com.example.casestudy.model.employee.RoleApp;
import com.example.casestudy.repository.employee.IRoleRepository;
import com.example.casestudy.service.employee.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository iRoleRepository;

    @Override
    public List<RoleApp> findRole() {
        return iRoleRepository.findRole();
    }
}
