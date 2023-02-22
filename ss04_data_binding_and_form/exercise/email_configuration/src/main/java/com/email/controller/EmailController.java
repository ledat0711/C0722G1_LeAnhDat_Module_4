package com.email.controller;

import com.email.model.Email;
import com.email.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailController {

    @Autowired
    IEmailService emailService;

    @GetMapping("/")
    public String toMailForm(Model model){
        List<String> languageList = emailService.collectLanguage();
        List<String> pageSizeList = emailService.collectPageSize();
        model.addAttribute("languageList",languageList);
        model.addAttribute("pageSizeList",pageSizeList);
        model.addAttribute("email", new Email());
        return "/mail_form";
    }

    @PostMapping("/show-result")
    public String showResult(@ModelAttribute Email email, Model model){
        List<Email> emailList = emailService.showResultConfig(email);
        model.addAttribute("emailList",emailList);
        return "/result_config";
    }
}
