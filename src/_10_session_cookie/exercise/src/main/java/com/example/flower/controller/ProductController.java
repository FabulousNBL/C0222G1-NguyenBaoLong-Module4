package com.example.flower.controller;


import com.example.flower.model.Cart;
import com.example.flower.model.Flower;
import com.example.flower.service.impl.IFlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    private IFlowerService iFlowerService;

    @ModelAttribute("cart")
    public Cart productInCart() {
        return new Cart();
    }



    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("flowerList", iFlowerService.getAll());
        return "home";
    }

    @GetMapping("addToCart/{id}")
    public String addToCart(@PathVariable int id,
                            @ModelAttribute("cart") Cart cart,
                            @RequestParam("action") String action
    ) {
        Flower flower = iFlowerService.findById(id);

        if (action.equals("show")) {
            cart.addProduct(flower);
            return "redirect:/cart";
        }
        cart.addProduct(flower);
        return "redirect:/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") int id, Model model){
        model.addAttribute("flower", iFlowerService.findById(id));
        return "view";
    }


    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Integer id, @ModelAttribute Cart cart, @RequestParam("action") String action,
                            RedirectAttributes redirectAttributes){
        Flower flower = iFlowerService.findById(id);

        if (action.equals("show")) {
            cart.addProduct(flower);
            return "redirect:/cart";
        }
        cart.addProduct(flower);
        redirectAttributes.addFlashAttribute("msg", "Product added to cart successfully");
        return "redirect:/cart";
    }

    @GetMapping("/decrease/{id}")
    public String decreaseProduct(@PathVariable Integer id, @ModelAttribute Cart cart){
        Flower flower = iFlowerService.findById(id);

        cart.decreaseProduct(flower);
        return "redirect:/cart";
    }
}