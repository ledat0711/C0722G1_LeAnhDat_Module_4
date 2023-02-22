package com.change_money.controller;

import com.change_money.service.IChangeMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeMoneyController {

    @Autowired
    private IChangeMoneyService changeMoneyService;

    @GetMapping("/")
    public String changeMoney(){
        return "/home";
    }

    @PostMapping("/change")
    public String changeToUSD(@RequestParam double usd, Model model){
        double answer = changeMoneyService.changeMoney(usd);
        model.addAttribute("answer", answer);
        return "/home";
    }
}
