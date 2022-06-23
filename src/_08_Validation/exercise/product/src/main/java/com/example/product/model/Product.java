package com.example.product.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity(name = "product")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", columnDefinition = "varchar(200)")
    @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Không được để trống, không được nhập các ký tự đặc biệt như @ ; , . = - + , …. ")
    @NotBlank(message = "Không được để trống")
    @Size(min = 1, max = 300, message = "Không thể nhập quá 300 ký tự")
    private String name;

    @Column(name = "price", columnDefinition = "Double")
    private double price;

    @Column(name = "description", columnDefinition = "varchar(200)")
    @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Không được để trống, không được nhập các ký tự đặc biệt như @ ; , . = - + , …. ")
    @NotBlank(message = "Không được để trống")
    @Size(min = 1, max = 800, message = "Không thể nhập quá 800 ký tự")
    private String description;

    @Column(name = "producer", columnDefinition = "varchar(200)")
    @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Không được để trống, không được nhập các ký tự đặc biệt như @ ; , . = - + , …. ")
    @NotBlank(message = "Không được để trống")
    @Size(min = 1, max = 300, message = "Không thể nhập quá 300 ký tự")
    private String producer;

    @Column(name = "status", columnDefinition = "bit")
    @ColumnDefault("0")
    private int status;

    public Product() {
    }

    public Product(int id, @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Không được để trống, không được nhập các ký tự đặc biệt như @ ; , . = - + , …. ") @NotBlank(message = "Không được để trống") @Size(min = 1, max = 300, message = "Không thể nhập quá 300 ký tự") String name, double price, @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Không được để trống, không được nhập các ký tự đặc biệt như @ ; , . = - + , …. ") @NotBlank(message = "Không được để trống") @Size(min = 1, max = 800, message = "Không thể nhập quá 800 ký tự") String description, @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Không được để trống, không được nhập các ký tự đặc biệt như @ ; , . = - + , …. ") @NotBlank(message = "Không được để trống") @Size(min = 1, max = 300, message = "Không thể nhập quá 300 ký tự") String producer, int status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.producer = producer;
        this.status = status;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}


