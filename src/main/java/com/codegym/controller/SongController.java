package com.codegym.controller;

import com.codegym.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SongController {
    @GetMapping("/input-song")
    public String showInputSong(Model model){
        model.addAttribute("song",new Song());
        return "/index";
    }
    @PostMapping("/validate")
    public String checkValidate(@Valid @ModelAttribute Song song, Model model, BindingResult bindingResult){
        new Song().validate(song,bindingResult);
        if(bindingResult.hasErrors()){
            return "/index";
        }
        else {
            model.addAttribute("song",new Song());
            return "/result";
        }
    }
}
