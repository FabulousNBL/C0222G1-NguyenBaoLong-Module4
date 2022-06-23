package com.example.music.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity(name = "music")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Pattern(regexp = "^[A-Za-z0-9 ]*$",message = "Không được để trống, không được nhập các ký tự đặc biệt như @ ; , . = - + , …. ")
    @NotBlank(message = "Không được để trống")
    @Size(min =1 ,max = 800, message = "Không thể nhập quá 800 ký tự")
    private String name;

    @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Không được để trống, không được nhập các ký tự đặc biệt như @ ; , . = - + , …. ")
    @NotBlank(message = "Không được để trống")
    @Size(min =1,max = 300, message = "Không được nhập quá 300 ký tự")
    private String singer;

    @Pattern(regexp = "^[A-Za-z0-9, ]*$", message = "Không được để trống, ngoại trừ dấu ',' không được nhập các ký tự đặc biệt như @ ; . = - + , …. ")
    @NotBlank(message = "Không được để trống")
    @Size(min = 1, max = 1000, message = "Không được nhập quá 1000 kí tự")
    private String type;

    public Song() {
    }

    public Song(int id, @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Không được để trống, không được nhập các ký tự đặc biệt như @ ; , . = - + , …. ") @Size(min = 1, max = 800, message = "Không thể nhập quá 800 ký tự") String name, @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Không được để trống, không được nhập các ký tự đặc biệt như @ ; , . = - + , …. ") @Size(min = 1, max = 300, message = "Không được nhập quá 300 ký tự") String singer, @Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Không được để trống, ngoại trừ dấu ',' không được nhập các ký tự đặc biệt như @ ; . = - + , …. ") @Size(min = 1, max = 1000, message = "Không được nhập quá 1000 kí tự") String type) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
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

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
