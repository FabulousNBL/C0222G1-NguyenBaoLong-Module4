package com.example.casestudy.controller;

import com.example.casestudy.dto.ContractDto;
import com.example.casestudy.model.contract.Contract;
import com.example.casestudy.repository.customer.ICustomerRepository;
import com.example.casestudy.repository.customer.ICustomerTypeRepository;
import com.example.casestudy.repository.employee.IEmployeeRepository;
import com.example.casestudy.repository.service.IServiceRepository;
import com.example.casestudy.service.business.IService;
import com.example.casestudy.service.contract.IAttachService;
import com.example.casestudy.service.contract.IContractService;
import com.example.casestudy.service.contractDetail.IContractDetailService;
import com.example.casestudy.service.customer.ICustomerService;
import com.example.casestudy.service.employee.IEmployeeService;
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
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IAttachService attachService;

    @Autowired
    private IContractService iContractService;

    @Autowired
    private ICustomerRepository customerService;

    @Autowired
    private IEmployeeRepository employeeService;

    @Autowired
    private IServiceRepository iService;

    @Autowired
    private IContractDetailService detailService;

    @GetMapping("/list")
    public String home(@PageableDefault (value = 2)Pageable pageable, Model model){
        model.addAttribute("contractList", iContractService.findAllContract(pageable));
        model.addAttribute("employeeList", employeeService.findAll());
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("serviceList", iService.findAll());
        model.addAttribute("attachServiceList", attachService.findAll());
        model.addAttribute("contractDetailList", detailService.findAll());
        return "/contract/list";
    }

    @GetMapping("/create")
    public String create (Model model){
        model.addAttribute("contract", new Contract());
        model.addAttribute("employeeList", employeeService.findAll());
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("serviceList", iService.findAll());

        return "/contract/create";

    }

    @PostMapping("/create")
    public String addNew(@Valid @ModelAttribute("contract") Contract contract, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("employeeList", employeeService.findAll());
            model.addAttribute("customerList", customerService.findAll());
            model.addAttribute("serviceList", iService.findAll());

            return "/contract/create";
        }

        iContractService.create(contract);
        redirectAttributes.addFlashAttribute("msg", "Add new successful");
        return "redirect:/contract/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") int id, Model model){
        Contract contract= iContractService.findById(id);

        model.addAttribute("contractDetail", detailService.findByContract(contract.getId()));
        return "/contract/list";
    }
}
