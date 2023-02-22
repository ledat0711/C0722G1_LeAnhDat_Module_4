package com.dictionary.controller;

import com.dictionary.repository.IDictionaryRepository;
import com.dictionary.service.IDictionaryService;
import com.dictionary.service.impl.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {

    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping("/")
    public String toHome(){
        return "/home";
    }

    @GetMapping("/list")
    public String showAnswer(@RequestParam String englishWord, Model model){
        String answer = dictionaryService.displayAnswer(englishWord);
        model.addAttribute("answer", answer);
        model.addAttribute("englishWord", englishWord);
        return "/home";
    }
}