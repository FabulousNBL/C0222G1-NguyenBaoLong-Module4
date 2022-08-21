package com.example.demo.controller;

import com.example.demo.service.IBenhAnService;
import com.example.demo.service.IBenhNhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BenhAnController {
    @Autowired
    @Qualifier(value = "benhAn")
    private IBenhAnService benhAnService;
    @Autowired
    private IBenhNhanService benhNhanService;

    @GetMapping("/show")
    public String showAllBenhAn(@PageableDefault(value = 1) Pageable pageable, Model model) {
        model.addAttribute("benhans", benhAnService.findAll(pageable));
        model.addAttribute("benhnhans", benhNhanService.findAll());
        return "list";
    }
}
