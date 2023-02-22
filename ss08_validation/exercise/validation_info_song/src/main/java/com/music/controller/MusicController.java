package com.music.controller;

import com.music.dto.MusicDto;
import com.music.model.Music;
import com.music.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;

@Controller
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping("/")
    public String displayList(Model model) {
        model.addAttribute("musicList", musicService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String displayCreateForm(Model model) {
        model.addAttribute("musicDto", new Music());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("musicDto")
                                     MusicDto musicDto,
                         BindingResult bindingResult,
                         Model model) {

        new MusicDto().validate(musicDto, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("musicDto", musicDto);
            return "create";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        musicService.save(music);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String showEditForm(@RequestParam Integer id, Model model) {
        model.addAttribute("musicDto", musicService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String edit(@ModelAttribute("musicDto") @Valid MusicDto musicDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "update";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        musicService.save(music);
        return "redirect:/";
    }

}
