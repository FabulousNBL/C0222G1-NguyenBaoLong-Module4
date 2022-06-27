package com.example.book.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int amount;
    private String author;
    private int status;

    @OneToMany(mappedBy = "book")
    private Set<Detail> customers;

    public Book() {
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Set<Detail> getCustomers() {

        return customers;
    }

    public void setCustomers(Set<Detail> customers) {
        this.customers = customers;
    }
}
