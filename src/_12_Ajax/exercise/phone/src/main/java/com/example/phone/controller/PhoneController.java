package com.example.phone.controller;

import com.example.phone.model.Phone;
import com.example.phone.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/smartphones")
public class PhoneController {
    @Autowired
    private IPhoneService iPhoneService;

    @GetMapping
    public ResponseEntity<List<Phone>> allPhone() {
        return new ResponseEntity<>(iPhoneService.getAll(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Phone> createSmartphone(@RequestBody Phone phone) {
        return new ResponseEntity<>(iPhoneService.save(phone), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Phone> deletePhone(@PathVariable int id) {
        Phone deletePhone = iPhoneService.findById(id);
        if (deletePhone == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iPhoneService.remove(id);
        return new ResponseEntity<>(deletePhone, HttpStatus.NO_CONTENT);
    }

    @PutMapping("/edit")
    public ResponseEntity<List<Phone>> update(@RequestBody Phone phone) {
        iPhoneService.save(phone);
        return new ResponseEntity<>(iPhoneService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Phone> findById(@PathVariable("id") int id) {
        Phone phone = iPhoneService.findById(id);
        if (phone == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(phone, HttpStatus.OK);
    }
}
