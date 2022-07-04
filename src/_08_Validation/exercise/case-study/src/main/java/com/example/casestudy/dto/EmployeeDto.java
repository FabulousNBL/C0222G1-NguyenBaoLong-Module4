package com.example.casestudy.dto;

import com.example.casestudy.model.employee.Degree;
import com.example.casestudy.model.employee.Division;
import com.example.casestudy.model.employee.Position;
import com.example.casestudy.model.employee.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class EmployeeDto {
    private int id;
    @NotEmpty(message = "Name mustn't empty")
    private String name;
    private String birthday;
    @Pattern(regexp = "^[0-9]{12}|[0-9]{9}", message = "ID card not ok! Please retry. Id must have 9 or 12 number")
    private String cardId;
    private double salary;
    @Pattern(regexp = "^(090[0-9]{7})|(091[0-9]{7})|((84)+90[0-9]{7})|((84)+91[0-9]{7})$", message = "Phone incorrect! please retry. Ex:090xxxxxxx or 091xxxxxxx(x is number 0-9)")
    private String phone;
    @Pattern(regexp = "^[A-Za-z0-9]+@([a-z]+\\.)+[a-z]{2,4}$", message = "Email is wrong! please retry. Ex:abc@gmail.com")
    private String email;
    @NotBlank(message = "Can't be empty")
    private String address;
    private Degree degree;
    private Division division;
    private Position position;
    private User user;

    public EmployeeDto() {
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
