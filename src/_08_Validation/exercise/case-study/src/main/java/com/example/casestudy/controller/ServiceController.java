package com.example.casestudy.controller;

import com.example.casestudy.dto.CustomerDto;
import com.example.casestudy.dto.ServiceDto;
import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.model.service.Service;
import com.example.casestudy.service.business.IRentTypeService;
import com.example.casestudy.service.business.IService;
import com.example.casestudy.service.business.ITypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private IService iService;

    @Autowired
    private IRentTypeService rentTypeService;

    @Autowired
    private ITypeService iTypeService;

    @GetMapping("/list")
    public String listCustomer(@PageableDefault(value = 2) Pageable pageable, Model model){
        model.addAttribute("serviceList", iService.findAllService(pageable));
        return "/service/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("rentTypeList",rentTypeService.findAll());
        model.addAttribute("typeServiceList", iTypeService.findAll());
        model.addAttribute("service", new ServiceDto());
        return "/service/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("service") ServiceDto serviceDto,
                         BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("rentTypeList", rentTypeService.findAll());
            model.addAttribute("typeServiceList", iTypeService.findAll());
            return "/service/create";
        }

        com.example.casestudy.model.service.Service service= new Service();
        BeanUtils.copyProperties(serviceDto,service);

        iService.create(service);
        redirectAttributes.addFlashAttribute("msg", " Add new service successful");
        return "redirect:/service/list";
    }
}
