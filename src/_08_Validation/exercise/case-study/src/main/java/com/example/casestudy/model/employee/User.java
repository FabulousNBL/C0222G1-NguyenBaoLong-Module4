package com.example.casestudy.model.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    private String userName;

    private String password;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_name"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roleUser;

    @OneToOne(mappedBy = "user")
    @JsonBackReference
    private Employee employee;

    public User(String userName, String password, Set<Role> roleUser, Employee employee) {
        this.userName = userName;
        this.password = password;
        this.roleUser = roleUser;
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(Set<Role> roleUser) {
        this.roleUser = roleUser;
    }
}
