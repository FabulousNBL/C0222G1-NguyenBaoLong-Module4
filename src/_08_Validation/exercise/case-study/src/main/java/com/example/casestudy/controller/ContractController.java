package com.example.casestudy.controller;

import com.example.casestudy.dto.ContractDto;
import com.example.casestudy.model.contract.Contract;
import com.example.casestudy.repository.customer.ICustomerRepository;
import com.example.casestudy.repository.customer.ICustomerTypeRepository;
import com.example.casestudy.repository.employee.IEmployeeRepository;
import com.example.casestudy.repository.service.IServiceRepository;
import com.example.casestudy.service.business.IService;
import com.example.casestudy.service.contract.IContractService;
import com.example.casestudy.service.customer.ICustomerService;
import com.example.casestudy.service.employee.IEmployeeService;
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
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;

    @Autowired
    private ICustomerRepository customerService;

    @Autowired
    private IEmployeeRepository employeeService;

    @Autowired
    private IServiceRepository iService;

    @GetMapping("/list")
    public String home(@PageableDefault (value = 2)Pageable pageable, Model model){
        model.addAttribute("contractList", iContractService.findAllContract(pageable));
        model.addAttribute("employeeList", employeeService.findAll());
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("serviceList", iService.findAll());
        return "/contract/list";
    }

    @GetMapping("/create")
    public String create (Model model){
        model.addAttribute("contract", new ContractDto());
        model.addAttribute("employeeList", employeeService.findAll());
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("serviceList", iService.findAll());

        return "/contract/create";

    }

    @PostMapping("/create")
    public String addNew(@Valid @ModelAttribute("contract") ContractDto contractDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("employeeList", employeeService.findAll());
            model.addAttribute("customerList", customerService.findAll());
            model.addAttribute("serviceList", iService.findAll());

            return "/contract/create";
        }

        Contract contract= new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        iContractService.create(contract);
        redirectAttributes.addFlashAttribute("msg", "Add new successful");
        return "redirect:/contract/list";
    }
}
