package com.example.casestudy.model.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RoleApp {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "roleAppUser")
    @JsonBackReference
    private Set<UserApp> userApp;

    public RoleApp() {
    }

    public RoleApp(int id, String name, Set<UserApp> userApp) {
        this.id = id;
        this.name = name;
        this.userApp = userApp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserApp> getUserApp() {
        return userApp;
    }

    public void setUserApp(Set<UserApp> userApp) {
        this.userApp = userApp;
    }
}
