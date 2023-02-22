package com.register.controller;

import com.register.dto.UserDto;
import com.register.model.User;
import com.register.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("validateUser", new UserDto());
        return "create";
    }

    @PostMapping("/create")
    public String createUser( @ModelAttribute("validateUser") @Valid UserDto validateUser, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new UserDto().validate(validateUser, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        User user = new User();
        BeanUtils.copyProperties(validateUser, user);
        userService.add(user);
        redirectAttributes.addFlashAttribute("msg", "Create success!");
        return "redirect:/";
    }

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "list";
    }
}
