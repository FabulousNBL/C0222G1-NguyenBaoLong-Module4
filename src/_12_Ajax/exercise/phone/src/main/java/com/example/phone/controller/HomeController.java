package com.example.phone.controller;

import com.example.phone.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private IPhoneService iPhoneService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("phoneList", iPhoneService.getAll());
        return "/rest/home";
    }
}
