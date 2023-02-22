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
    public String goListCategory(Model model){
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        return "category/listCategory";
    }
    @GetMapping("/createCategory")
    public String goCreate(Model model) {
        model.addAttribute("category", new Category());
        return "category/createCategory";
    }

    @PostMapping("/createCategory")
    public String create(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/category";
    }
    @GetMapping("/updateCategory/{id}")
    public String showUpdate(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", categoryService.findById(id));
        return "category/updateCategory";
    }

    @PostMapping("/updateCategory")
    public String update(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/category";
    }
    @GetMapping("/deleteCategory")
    public String delete(@RequestParam Integer id) {
        categoryService.delete(id);
        return "redirect:/category";
    }

}
