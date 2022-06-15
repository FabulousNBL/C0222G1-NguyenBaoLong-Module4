package exchange.controller;

import exchange.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExchangeController {
    @Autowired
    private ExchangeService ExchangeService;

    @GetMapping("/change")
    public String home() {
        return "/home";
    }

    @PostMapping("/change")
    public String exchange(@RequestParam(name = "usd") String usd, Model model) {
        model.addAttribute("total", ExchangeService.exchange(usd));
        model.addAttribute("usd", usd);
        return "/home";
    }
}
