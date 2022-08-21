package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "benh_nhan")
@Getter
@Setter
public class BenhNhan {
    @Id
    @Column(name = "id_benh_nhan")
    private String id;
    private String name;

    @OneToMany(mappedBy = "benhNhan")
    @JsonBackReference
    private Set<BenhAn> benhAns;


    public BenhNhan() {
    }

    public BenhNhan(String id, String name, Set<BenhAn> benhAns) {
        this.id = id;
        this.name = name;
        this.benhAns = benhAns;
    }
}
