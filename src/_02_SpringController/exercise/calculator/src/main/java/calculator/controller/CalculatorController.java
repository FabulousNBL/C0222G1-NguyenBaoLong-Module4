package calculator.controller;

import calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService iCalculatorService;

    @GetMapping
    public String home() {
        return "index";
    }

    @PostMapping("/calculate")
    public String result(@RequestParam("number1") double number1,
                         @RequestParam("number2") double number2,
                         @RequestParam("operator") char operator,
                         Model model) {
        model.addAttribute("result", iCalculatorService.calculate(number1, number2, operator));
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        return "index";
    }
}
