package com.example.casestudy.controller;

import com.example.casestudy.dto.CustomerDto;
import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.service.customer.ICustomerService;
import com.example.casestudy.service.customer.ICustomerTypeService;
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
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("/list")
    public String listCustomer(@PageableDefault(value = 2) Pageable pageable, Model model){
        model.addAttribute("customerList", customerService.findAllCustomer(pageable));
        return "/customer/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        model.addAttribute("customer", new CustomerDto());
        return "/customer/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("customer") CustomerDto customerDto,
                         BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("customerTypeList", iCustomerTypeService.findAll());

            return "/customer/create";
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);

        customerService.create(customer.getCodeCustomer(),customer.getName(),customer.getBirthday(),customer.getGender(),customer.getCustomerIdCard(),customer.getPhone(),customer.getEmail(),customer.getAddress(),customer.getCustomerType().getId());
        redirectAttributes.addFlashAttribute("msg", " Add new customer successful");
        return "redirect:/customer/list";
    }

    @GetMapping("/edit/{id}")
    public String update(@PathVariable ("id") int id, Model model){
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        model.addAttribute("customer", customerService.findById(id));
        return "/customer/edit";
    }

    @PostMapping("/edit")
    public String edit (@Valid @ModelAttribute("customer") CustomerDto customerDto, BindingResult bindingResult,
                        RedirectAttributes redirectAttributes, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
            return "/customer/edit";
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg", " Edit successful");
        return "redirect:/customer/list";
    }

    @GetMapping("/delete/{id}")
    public String delete (@PathVariable("id") int id, Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "/customer/delete";
    }

    @PostMapping("/delete")
    public String remove(Customer customer){
        Customer customerDelete = customerService.findById(customer.getId());
        customerDelete.setStatus(1);
        customerService.save(customerDelete);

        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String search(@PageableDefault( value = 2) Pageable pageable, Model model, String name){
        model.addAttribute("customerList", customerService.findByName(name, pageable));
        return "/customer/list";
    }

}
