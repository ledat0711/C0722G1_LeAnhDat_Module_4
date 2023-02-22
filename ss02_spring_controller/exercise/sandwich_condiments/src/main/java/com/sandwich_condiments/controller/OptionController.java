package com.sandwich_condiments.controller;

import com.sandwich_condiments.service.IOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OptionController {

    @Autowired
    private IOptionService optionService;

    @GetMapping("/")
    public String toHome(Model model){
        List<String> optionList = optionService.listOption();
        model.addAttribute("optionList", optionList);
        return "/home";
    }

    @GetMapping("/display")
    public String listOption(@RequestParam List<String> optionSelected, Model model){
        List<String> answerList = optionSelected;
        model.addAttribute("answerList", answerList);
        return "/answer";
    }
}
