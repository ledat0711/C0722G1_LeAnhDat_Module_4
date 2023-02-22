package com.personal_calculator.controller;

import com.personal_calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    ICalculatorService calculatorService;

    @GetMapping("/")
    public String toHome(Model model) {
        return "/home";
    }

    @PostMapping("/work")
    public String solve(@RequestParam String action, @RequestParam double firstNum,
                      @RequestParam double secondNum, Model model) {
        String answer = calculatorService.calculate(action,firstNum,secondNum);
        model.addAttribute("answer",answer);
        return "/home";
    }
}
