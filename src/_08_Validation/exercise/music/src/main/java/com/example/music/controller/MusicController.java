package com.example.music.controller;

import com.example.music.model.Song;
import com.example.music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MusicController {

    @Autowired
    private IMusicService iMusicService;

    @GetMapping
    public String home(Model model){
        model.addAttribute("songList", iMusicService.findAllMusic());
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("song",new Song());
        return "/create";
    }

    @PostMapping("/create")
    public String add(@Valid @ModelAttribute("song") Song song, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/create";
        }

        iMusicService.create(song.getName(),song.getSinger(),song.getType());
        return "redirect:/";
    }

    @GetMapping("{id}/edit")
    public String edit (@PathVariable("id") int id, Model model){
        model.addAttribute("song", iMusicService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute("song") Song song, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/edit";
        }

        iMusicService.edit(song.getName(),song.getSinger(),song.getType(),song.getId());
        return "redirect:/";
    }
}
