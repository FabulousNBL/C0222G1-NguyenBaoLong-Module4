package com.example.casestudy.model.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
public class UserApp {
    @Id
    @Pattern(regexp = "^[a-zA-Z0-9]{6,15}$")
    private String userName;

    @Pattern(regexp = "^[a-zA-Z0-9]{6,15}$")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_name"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleApp> roleAppUser;

    @OneToOne(mappedBy = "userApp")
    @JsonBackReference
    private Employee employee;

    public UserApp(String userName, String password, Set<RoleApp> roleAppUser, Employee employee) {
        this.userName = userName;
        this.password = password;
        this.roleAppUser = roleAppUser;
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public UserApp() {
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

    public Set<RoleApp> getRoleAppUser() {
        return roleAppUser;
    }

    public void setRoleAppUser(Set<RoleApp> roleAppUser) {
        this.roleAppUser = roleAppUser;
    }
}
