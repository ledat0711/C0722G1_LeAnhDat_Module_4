package com.blog.controller;

import com.blog.model.Blog;
import com.blog.model.Category;
import com.blog.service.IBlogService;
import com.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/blog")
    public String goPage(Model model, @PageableDefault(5) Pageable pageable,
                         @RequestParam Optional <String> name,
                         @RequestParam(required = false, defaultValue = "") String author) {
        for (Sort.Order order: pageable.getSort()) {
            model.addAttribute("sortValue", order.getProperty());
        }
        String keyName = name.orElse("");
        Page<Blog> blogPage = blogService.findAll(pageable,keyName, author);
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("name", keyName);
        model.addAttribute("author", author);
        return "blog/list";
    }

    @GetMapping("/create")
    public String goCreate(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable Integer id, Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("blog", blogService.findById(id));
        return "blog/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        blogService.delete(id);
        return "redirect:/blog";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam Integer id) {
        blogService.findById(id);
        return "redirect:/blog";
    }

}
