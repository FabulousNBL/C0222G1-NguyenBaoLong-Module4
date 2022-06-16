package mailBox.controller;

import mailBox.model.MailBox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailController {


    @GetMapping
    public String moveToCreate(Model model){
        int[] size= new int[] {5,10,15,25,50,100};
        String[] language= new String[] {"English","Vietnamese","Japanese","chinese"};
        model.addAttribute("language",language);
        model.addAttribute("mailBox",new MailBox());
        model.addAttribute("pageSize", size);
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute MailBox mailBox, Model model){
        model.addAttribute("mailBox",mailBox);
        return "detail";
    }
}
