package com.example.casestudy.rest;

import com.example.casestudy.dto.EmployeeDto;
import com.example.casestudy.model.employee.Employee;
import com.example.casestudy.model.employee.User;
import com.example.casestudy.service.employee.IEmployeeService;
import com.example.casestudy.service.employee.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee-rest")
public class EmployeeRestController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IUserService userService;

    @GetMapping("")
//    public ResponseEntity<List<Employee>> getAll( @PageableDefault( value = 5) Pageable pageable){
//        iEmployeeService.findAllEmployee(pageable).getContent();
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
    public ResponseEntity<List<Employee>> getAll(@RequestParam(name = "page", defaultValue = "0") int page ){

        return new ResponseEntity<>(iEmployeeService.findAllEmployee(PageRequest.of(page,2)).getContent(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id){
        Employee employee= iEmployeeService.findById(id);
        if (employee == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/remove/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") int id,@RequestParam(name = "page", defaultValue = "0") int page){
        Employee temp = iEmployeeService.findById(id);
        temp.setStatus(1);
        iEmployeeService.create(temp);
        List<Employee> employees = iEmployeeService.findAllEmployee(PageRequest.of(page,2)).getContent();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addNew(@RequestBody Employee employee, @RequestParam(name = "page", defaultValue = "0") int page){
        userService.create(employee.getUser());
        iEmployeeService.create(employee);
        List<Employee> employees = iEmployeeService.findAllEmployee(PageRequest.of(page,2)).getContent();
        return new ResponseEntity<>(employees,HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<List<Employee>> edit(@RequestParam(value = "page", defaultValue = "0") int page, @RequestBody Employee employee){
        iEmployeeService.create(employee);
        List<Employee> employees = iEmployeeService.findAllEmployee(PageRequest.of(page,2)).getContent();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }


}
