package com.example.casestudy.dto;

import com.example.casestudy.model.contract.Contract;
import com.example.casestudy.model.service.RentType;
import com.example.casestudy.model.service.ServiceType;

public class ServiceDto {

    private int id;

    private String name;
    private int area;
    private double cost;
    private int amountCustomer;
    private String standardRoom;
    private String description;
    private int poolArea;
    private int floor;
    private RentType rentType;
    private ServiceType serviceType;
    private Contract contract;

    public ServiceDto() {
    }

    public ServiceDto(int id, String name, int area, double cost, int amountCustomer, String standardRoom, String description, int poolArea, int floor, RentType rentType, ServiceType serviceType, Contract contract) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.amountCustomer = amountCustomer;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.floor = floor;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.contract = contract;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getAmountCustomer() {
        return amountCustomer;
    }

    public void setAmountCustomer(int amountCustomer) {
        this.amountCustomer = amountCustomer;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(int poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
