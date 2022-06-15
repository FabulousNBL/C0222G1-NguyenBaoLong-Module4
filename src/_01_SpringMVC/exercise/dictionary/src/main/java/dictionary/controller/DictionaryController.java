package dictionary.controller;

import dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService IDictionaryService;

    @GetMapping("/")
    public String home() {
        return "/index";
    }

    @PostMapping("/trans")
    public String translate(@RequestParam String word, Model model) {
        model.addAttribute("trans", IDictionaryService.dictionary(word));
        model.addAttribute("findWord", word);
        return "/index";
    }
}
