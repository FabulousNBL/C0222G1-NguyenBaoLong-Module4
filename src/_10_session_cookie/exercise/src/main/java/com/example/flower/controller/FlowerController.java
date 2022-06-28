package com.example.flower.controller;

import com.example.flower.model.Cart;
import com.example.flower.model.Flower;
import com.example.flower.service.IFlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Controller
@SessionAttributes("flowerList")
public class FlowerController {
    @ModelAttribute("flowerList")
    public Map<Flower, Integer> setupCart() {
        return new HashMap<>();
    }


    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable("id") int id,
                            @ModelAttribute Map<Flower, Integer> map,
                            Model model){
        Map<Flower, Integer> flowers= new HashMap<>();
        for (Map.Entry<Flower, Integer> item: flowers.entrySet()){

        }
        Flower flower1= iFlowerService.findById(id);
        map.put(flower1,)
        return "redirect:/";
    }

    @Autowired
    private IFlowerService iFlowerService;


    @GetMapping
    public String home(Model model){
        model.addAttribute("flowerList",iFlowerService.getAll());
        return "/home";
    }

    @GetMapping("/view/{id}")
    public String view (@PathVariable("id") int id, Model model){
        model.addAttribute("flower", iFlowerService.findById(id));
        return "/view";
    }

}
