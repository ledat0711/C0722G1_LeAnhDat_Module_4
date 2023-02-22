package com.blog.controller;

import com.blog.model.Blog;
import com.blog.model.Category;
import com.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("/category")
    public String goListCategory(@RequestParam(required = false, defaultValue = "") String name,Model model){
        List<Category> categoryList = categoryService.findAllByNameContaining(name);
        model.addAttribute("categoryList",categoryList);
        return "category/list";
    }
    @GetMapping("/create-category")
    public String goCreate(Model model) {
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping("/create-category")
    public String create(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/category";
    }
    @GetMapping("/update-category/{id}")
    public String showUpdate(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", categoryService.findById(id));
        return "category/update";
    }

    @PostMapping("/update-category")
    public String update(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/category";
    }
    @GetMapping("/delete-category")
    public String delete(@RequestParam Integer id) {
        categoryService.delete(id);
        return "redirect:/category";
    }

}
