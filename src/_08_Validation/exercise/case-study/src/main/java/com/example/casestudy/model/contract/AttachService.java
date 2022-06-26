package com.example.casestudy.model.contract;

import javax.persistence.*;

@Entity
public class AttachService {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double cost;
    private int unit;
    private String status;

    @OneToOne(mappedBy = "attachService")
    private ContractDetail contractDetail;
}
