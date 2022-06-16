package medical.controller;

import medical.model.Medical;
import medical.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MedicalController {

    @Autowired
    private IMedicalService iMedicalService;


    @GetMapping
    public String home(Model model){
        model.addAttribute("medical", new Medical());
        model.addAttribute("age",iMedicalService.age());
        model.addAttribute("gender",iMedicalService.gender());
        model.addAttribute("nations",iMedicalService.nation());
        model.addAttribute("day",iMedicalService.day());
        model.addAttribute("month",iMedicalService.month());
        model.addAttribute("year",iMedicalService.year());
        return "index";
    }

    @PostMapping("submit")
    public String result(@ModelAttribute Medical medical, Model model){
        model.addAttribute("medical",medical);
        return "result";
    }
}
