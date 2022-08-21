package com.example.casestudy.rest;

import com.example.casestudy.model.employee.Employee;
import com.example.casestudy.service.employee.IEmployeeService;
import com.example.casestudy.service.employee.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> addNew(@Valid @RequestBody Employee employee, @RequestParam(name = "page", defaultValue = "0") int page){
        userService.create(employee.getUserApp());
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
