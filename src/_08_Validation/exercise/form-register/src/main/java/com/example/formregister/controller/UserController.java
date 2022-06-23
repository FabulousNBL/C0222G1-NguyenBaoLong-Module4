package com.example.formregister.controller;

import com.example.formregister.model.User;
import com.example.formregister.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping
    public String home(@RequestParam(value = "page", defaultValue = "0") int page, Model model){
        Sort sort=Sort.by("first_name").ascending();
        Page<User> list = iUserService.findAllUser(PageRequest.of(page,2,sort));
        model.addAttribute("userList", list);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("user", new User());
        return "/create";
    }

    @PostMapping("/create")
    public String add(@Valid @ModelAttribute(name = "user") User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/create";
        }

        iUserService.create(user.getLastName(),user.getFirstName(),user.getPhone(),user.getAge(), user.getEmail());

        return "redirect:/";
    }
}
