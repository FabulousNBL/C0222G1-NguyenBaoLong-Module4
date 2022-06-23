package com.example.formregister.model;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Pattern(regexp = "^[A-Za-z]*$",message = "Phải viết hoa chữ cái đầu")
    @Size(min = 1, max = 20, message = "Có nhiều nhất 20 kí tự")
//    @NotBlank(message = "Không được bỏ trống")
    @Column(name = "last_name")
    private String lastName;

    @Pattern(regexp = "^[A-Za-z ]*$") @Size(min = 1, max = 40,message = "Có nhiều nhất 40 kí tự")
    @Column(name = "first_name")
    private String firstName;

    @Pattern(regexp = "^0[0-9]{9}$",message = "Không được để trống")@Size(min = 10, max = 12, message = "Số điện thoại từ 10 - 12 số, bắt đàu bằng 0")
    private String phone;

    @NotNull
    @Min(value = 18, message = "Không được nhập tuổi nhỏ hơn 18")
    @Max(value = 100, message = "Không được nhập tuổi lớn hơn 100")
    private int age;

    @Pattern(regexp = "^[\\w\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Không được để trống và có định dạng đúng là xxx@xxx.xxxx")

    private String email;

    @ColumnDefault("0")
    private int status;

    public User() {
    }

    public User(int id, @Pattern(regexp = "^[A-Za-z ]*$", message = "Không được để trống") String lastName, @Pattern(regexp = "^[A-Za-z ]*$", message = "Không được để trống") String firstName, @Pattern(regexp = "^0[0-9]{9}$") @NotBlank(message = "Không được để trống") String phone, @NotNull @Min(value = 18, message = "Không được nhập tuổi nhỏ hơn 18") @Max(value = 100, message = "Không được nhập tuổi lớn hơn 100") int age, @Pattern(regexp = "^[\\w\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$") @NotBlank(message = "Không được để trống") String email, int status) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.age = age;
        this.email = email;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
