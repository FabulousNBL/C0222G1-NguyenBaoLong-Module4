package com.example.casestudy.controller;

import com.example.casestudy.service.contractDetail.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/contract-detail")
public class ContractDetailController {
    @Autowired
    private IContractDetailService iContractDetailService;

//    @GetMapping("")
//    public String home(@PageableDefault(value = 4) Pageable pageable, Model model){
//        model.addAttribute("contractDetailList", iContractDetailService.findAll());
//        return "/contractDetail/list";
//    }
}
