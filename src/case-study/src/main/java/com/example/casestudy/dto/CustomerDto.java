package com.example.casestudy.dto;

import com.example.casestudy.model.contract.Contract;
import com.example.casestudy.model.customer.CustomerType;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class CustomerDto {

    private int id;

    @Pattern(regexp = "^KH-[0-9]{4}$", message = "Customer code is wrong. Ex:KH-xxxx (x is number 0-9)")
    private String codeCustomer;

    @NotEmpty(message = "Name mustn't empty")
    private String name;

    private String birthday;

    private int gender;

    @Pattern(regexp = "^[0-9]{12}|[0-9]{9}", message = "ID card not ok! Please retry. Id must have 9 or 12 number")
    private String customerIdCard;

    @Pattern(regexp = "^(090[0-9]{7})|(091[0-9]{7})|((84)+90[0-9]{7})|((84)+91[0-9]{7})$", message = "Phone incorrect! please retry. Ex:090xxxxxxx or 091xxxxxxx(x is number 0-9)")
    private String phone;

    @Pattern(regexp = "^[A-Za-z0-9]+@([a-z]+\\.)+[a-z]{2,4}$", message = "Email is wrong! please retry. Ex:abc@gmail.com")
    private String email;

    @NotEmpty(message = "Address mustn't empty")
    private String address;

    private CustomerType customerType;

    private Set<Contract> contract;

    public CustomerDto() {
    }

    public Set<Contract> getContract() {
        return contract;
    }

    public void setContract(Set<Contract> contract) {
        this.contract = contract;
    }

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
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

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

