package com.example.casestudy.service.employee.impl;

import com.example.casestudy.model.employee.RoleApp;
import com.example.casestudy.model.employee.UserApp;
import com.example.casestudy.repository.employee.IRoleRepository;
import com.example.casestudy.repository.employee.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserRepository appUserRepository;

    @Autowired
    private IRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //Tìm đối tượng đang đăng nhập trong DB
        UserApp appUser = this.appUserRepository.findByUserName(userName);

        if (appUser == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        System.out.println("Found User: " + appUser);

        // [ROLE_USER, ROLE_ADMIN,..]
        Set<RoleApp> userRoleApps = appUser.getRoleAppUser();
//
        List<GrantedAuthority> grantList = new ArrayList<>();
        if (userRoleApps != null) {
            for (RoleApp userRoleApp : userRoleApps) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(userRoleApp.getName()); //ROLE_ADMIN, ROLE_USER
                grantList.add(authority);
            }
        }

        UserDetails userDetails = new User(appUser.getUserName(),
                appUser.getPassword(), grantList);

        return userDetails;
    }


}