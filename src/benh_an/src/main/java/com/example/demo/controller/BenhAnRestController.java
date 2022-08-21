package com.example.demo.controller;

import com.example.demo.model.BenhAn;
import com.example.demo.service.IBenhAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class BenhAnRestController {
    @Autowired
    @Qualifier(value = "benhAn")
    private IBenhAnService benhAnService;

    @PostMapping
    public ResponseEntity<BenhAn> createBenhAn(@Valid @RequestBody BenhAn benhAn) {
        String id = "KH-" + ((int) (Math.random() * 10000));
        benhAn.setId(id);
        return new ResponseEntity<>(benhAnService.save(benhAn), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<BenhAn>> show() {
        return new ResponseEntity<>(benhAnService.showAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BenhAn> findById(@PathVariable String id) {
        return new ResponseEntity<>(benhAnService.findById(id).get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BenhAn> deleteBenhAn(@PathVariable String id) {
        Optional<BenhAn> smartphoneOptional = benhAnService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        benhAnService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
