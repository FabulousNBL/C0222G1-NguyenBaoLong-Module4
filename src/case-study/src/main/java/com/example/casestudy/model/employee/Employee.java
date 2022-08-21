package com.example.casestudy.model.employee;

import com.example.casestudy.model.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{0,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){1,10}", message = "Không đúng định dạng. Phải viết hoa chữ cái đầu")
    private String name;

    @NotBlank(message = "Can't be empty")
    private String birthday;

    @Pattern(regexp = "^[0-9]{12}|[0-9]{9}", message = "ID card not ok! Please retry. Id must have 9 or 12 number")
    private String cardId;

    @Min(value = 3000000, message = "Cant be under 3 million")
    private double salary;

    @Pattern(regexp = "^(090[0-9]{7})|(091[0-9]{7})|((84)+90[0-9]{7})|((84)+91[0-9]{7})$", message = "Phone incorrect! please retry. Ex:090xxxxxxx or 091xxxxxxx(x is number 0-9)")
    private String phone;
    @Pattern(regexp = "^[A-Za-z0-9]+@([a-z]+\\.)+[a-z]{2,4}$", message = "Email is wrong! please retry. Ex:abc@gmail.com")
    private String email;
    @NotBlank(message = "Can't be empty")
    private String address;
    @ColumnDefault("0")
    private int status;

    @ManyToOne
    @JoinColumn(name = "degree_id", referencedColumnName = "id")
    private Degree degree;

    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "id")

    private Division division;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")

    private Position position;

    @OneToOne
    @JoinColumn(name = "user_name", referencedColumnName = "userName")
//    @JsonBackReference(value = "user_name")
    private UserApp userApp;

    public Employee() {
    }

    @OneToMany(mappedBy = "employee")
    @JsonBackReference(value = "employee")
    private Set<Contract> contract;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public UserApp getUserApp() {
        return userApp;
    }

    public void setUserApp(UserApp userApp) {
        this.userApp = userApp;
    }

    public Set<Contract> getContract() {
        return contract;
    }

    public void setContract(Set<Contract> contract) {
        this.contract = contract;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
