package com.example.casestudy.rest;

import com.example.casestudy.model.employee.Employee;
import com.example.casestudy.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee-rest")
public class EmployeeRestController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id){
        Employee employee= iEmployeeService.findById(id);
        if (employee == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/remove/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") int id, @PageableDefault( value = 2) Pageable pageable){
        Employee temp = iEmployeeService.findById(id);
        temp.setStatus(1);
        iEmployeeService.create(temp);
        return new ResponseEntity<>(iEmployeeService.findAllEmployee(pageable).getContent(),HttpStatus.OK);
    }



}
