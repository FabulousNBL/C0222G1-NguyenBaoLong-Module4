package com.example.flower.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "flower")
public class Flower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String codeFlower;
    private String name;
    private int price;

    public Flower() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeFlower() {
        return codeFlower;
    }

    public void setCodeFlower(String codeFlower) {
        this.codeFlower = codeFlower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
