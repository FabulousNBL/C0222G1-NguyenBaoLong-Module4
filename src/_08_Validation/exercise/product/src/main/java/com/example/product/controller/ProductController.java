package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping
    public String home(@RequestParam(name = "page", defaultValue = "0")int page,  Model model){
        Sort sort= Sort.by("name").ascending();
        Page<Product> list = iProductService.findAllProduct(PageRequest.of(page,1,sort));
        model.addAttribute("productList", list);
        return "/list";
    }

    @GetMapping("/create")
    public String create (Model model){
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/create")
    public String add(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/create";
        }

        iProductService.create(product.getName(),product.getPrice(),product.getDescription(),product.getProducer());

        return "redirect:/";
    }

    @GetMapping("{id}/edit")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute("product", iProductService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/edit";
        }

        iProductService.update(product.getName(),product.getPrice(),product.getDescription(),product.getProducer(),product.getId());

        return "redirect:/";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable("id") int id, Model model){
        model.addAttribute("product", iProductService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String remove(Product product){
        iProductService.delete(product.getId());
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "page", defaultValue = "0")int page,String name,  Model model) {
        model.addAttribute("productList", iProductService.searchByName(name,PageRequest.of(page,2)));
        return "/list";
    }

    @GetMapping("{id}/detail")
    public String detail(@PathVariable("id") int id, Model model){
        model.addAttribute("product", iProductService.findById(id));
        return "/detail";
    }
}
