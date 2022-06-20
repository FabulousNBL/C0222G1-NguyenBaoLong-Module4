package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import product.model.Product;
import product.service.IProductService;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping
    public String home(Model model){
        model.addAttribute("productList",iProductService.findAll());
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "/create";
    }

    @PostMapping("/create")
    public String add(Product product){
        iProductService.create(product);
        return "redirect:/";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("product",iProductService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(Product product){
        iProductService.update(product);
        return "redirect:/";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("product",iProductService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String remove(Product product){
        iProductService.delete(product.getId());
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(String nameProduct, Model model) {
        model.addAttribute("productList", iProductService.search(nameProduct));
        return "/index";
    }

    @GetMapping("/{id}/detail")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/detail";
    }
}
