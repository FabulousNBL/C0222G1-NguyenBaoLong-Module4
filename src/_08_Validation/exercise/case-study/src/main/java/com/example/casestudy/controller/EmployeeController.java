package com.example.casestudy.controller;

import com.example.casestudy.dto.CustomerDto;
import com.example.casestudy.dto.EmployeeDto;
import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.model.employee.Employee;
import com.example.casestudy.service.employee.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IDegreeService degreeService;

    @Autowired
    private IDivisionService divisionService;

    @Autowired
    private IPositionService positionService;

    @Autowired
    private IUserService iUserService;

    @GetMapping("/list")
    public String home(@PageableDefault( value = 2) Pageable pageable, Model model){
        model.addAttribute("degreeList", degreeService.findAll());
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("employeeList", iEmployeeService.findAllEmployee(pageable));
        return "/employee/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("userList", iUserService.findAll() );
        model.addAttribute("degreeList", degreeService.findAll());
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("employee", new EmployeeDto());
        return "/employee/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("employee") EmployeeDto employeeDto,
                         BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("degreeList", degreeService.findAll());
            model.addAttribute("divisionList", divisionService.findAll());
            model.addAttribute("positionList", positionService.findAll());

            return "/employee/create";
        }

        Employee employee= new Employee();
        BeanUtils.copyProperties(employeeDto, employee);

        iUserService.create(employee.getUser());

        iEmployeeService.create(employee);
        redirectAttributes.addFlashAttribute("msg", " Add new customer successful");
        return "redirect:/employee/list";
    }

    @GetMapping("/edit/{id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute("employee", iEmployeeService.findById(id));
        model.addAttribute("userList", iUserService.findAll() );
        model.addAttribute("degreeList", degreeService.findAll());
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("positionList", positionService.findAll());
        return "/employee/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("employee") EmployeeDto employeeDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            model.addAttribute("userList", iUserService.findAll() );
            model.addAttribute("degreeList", degreeService.findAll());
            model.addAttribute("divisionList", divisionService.findAll());
            model.addAttribute("positionList", positionService.findAll());
            return "/employee/edit";
        }

        Employee employee= new Employee();
        BeanUtils.copyProperties(employeeDto,employee);

        iEmployeeService.create(employee);
        redirectAttributes.addFlashAttribute("msg", "Edit successful");
        return "redirect:/employee/list";
    }
//
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable("id") int id, Model model){
//        model.addAttribute("employee", iEmployeeService.findById(id));
//        model.addAttribute("divisionList", divisionService.findAll());
//        model.addAttribute("positionList", positionService.findAll());
//        return "/employee/delete";
//    }

    @GetMapping("/delete/{id}")
    public String remove(@PathVariable("id") int id, Employee employee, RedirectAttributes redirectAttributes){
        Employee employeeDelete = iEmployeeService.findById(id);
        employeeDelete.setStatus(1);
        iEmployeeService.create(employeeDelete);
        redirectAttributes.addFlashAttribute("msg", "Delete successful");
        return "redirect:/employee/list";
    }

    @GetMapping("/search")
    public String search(@PageableDefault( value = 2) Pageable pageable, Model model, String name){
        model.addAttribute("employeeList", iEmployeeService.findByName(name, pageable));
        return "/employee/list";
    }
}
