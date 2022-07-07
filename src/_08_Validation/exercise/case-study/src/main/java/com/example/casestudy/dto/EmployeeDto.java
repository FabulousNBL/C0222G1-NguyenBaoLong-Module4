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
    private int degreeId;
    private int divisionId;
    private int positionId;
    private String userName;
    private String password;
    private User user;
    private int status = 0;

    public EmployeeDto() {
    }

    public EmployeeDto(int id, @NotEmpty(message = "Name mustn't empty") String name, String birthday, @Pattern(regexp = "^[0-9]{12}|[0-9]{9}", message = "ID card not ok! Please retry. Id must have 9 or 12 number") String cardId, double salary, @Pattern(regexp = "^(090[0-9]{7})|(091[0-9]{7})|((84)+90[0-9]{7})|((84)+91[0-9]{7})$", message = "Phone incorrect! please retry. Ex:090xxxxxxx or 091xxxxxxx(x is number 0-9)") String phone, @Pattern(regexp = "^[A-Za-z0-9]+@([a-z]+\\.)+[a-z]{2,4}$", message = "Email is wrong! please retry. Ex:abc@gmail.com") String email, @NotBlank(message = "Can't be empty") String address, int degreeId, int divisionId, int positionId, String userName, String password, User user, int status) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.cardId = cardId;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.degreeId = degreeId;
        this.divisionId = divisionId;
        this.positionId = positionId;
        this.userName = userName;
        this.password = password;
        this.user = user;
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

    public int getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(int degreeId) {
        this.degreeId = degreeId;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
