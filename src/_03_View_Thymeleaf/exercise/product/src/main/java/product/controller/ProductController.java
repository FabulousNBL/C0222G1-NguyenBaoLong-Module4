package product.controller;

import product.model.Product;
import product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("/")
    public String home(Model model) {
        List<Product> products = iProductService.findAll();
        model.addAttribute("products", products);
        model.addAttribute("product", new Product());
        return "/index";

    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/create")
    public String save(Product product) {
        product.setId(iProductService.findAll().get(iProductService.findAll().size() - 1).getId() + 1);
        iProductService.save(product);
        return "redirect:/";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(Product product) {
        iProductService.update(product.getId(), product);
        return "redirect:/";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String remove(Product product) {
        iProductService.remove(product.getId());
        return "redirect:/";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/view";
    }

    @GetMapping("/search")
    public String search(Product product, Model model) {
        model.addAttribute("products", iProductService.search(product.getName()));
        return "/index";
    }


}
