package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "benh_an")

public class BenhAn implements Validator {
    @Id
    @Column(name = "id_benh_an")
    private String id;
    @NotEmpty
    private String reason;
    private String datein;
    private String dateout;

    @ManyToOne
    @JoinColumn(name = "id_benh_nhan", referencedColumnName = "id_benh_nhan")
    private BenhNhan benhNhan;

    public BenhAn(String id, String reason, String datein, String dateout, BenhNhan benhNhan) {
        this.id = id;
        this.reason = reason;
        this.datein = datein;
        this.dateout = dateout;
        this.benhNhan = benhNhan;
    }

    public BenhAn() {
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BenhAn benhAn = (BenhAn) target;
        if (benhAn.datein.matches("^$")) {
            errors.rejectValue("datein", "datein.EmptyString");
        }
        if (!benhAn.datein.equals("") && !benhAn.dateout.equals("")) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate startDay = LocalDate.parse(benhAn.datein, formatter);
            LocalDate endDay = LocalDate.parse(benhAn.dateout, formatter);
            assert endDay != null;
            if (endDay.isBefore(startDay)) {
                errors.rejectValue("dateout", "endDay.invalidFormat");
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDatein() {
        return datein;
    }

    public void setDatein(String datein) {
        this.datein = datein;
    }

    public String getDateout() {
        return dateout;
    }

    public void setDateout(String dateout) {
        this.dateout = dateout;
    }

    public BenhNhan getBenhNhan() {
        return benhNhan;
    }

    public void setBenhNhan(BenhNhan benhNhan) {
        this.benhNhan = benhNhan;
    }
}
