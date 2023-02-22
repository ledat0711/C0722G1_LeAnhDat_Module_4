package com.product.controller;

import com.product.model.Product;
import com.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/")
    public String goList(@RequestParam(required = false, defaultValue = "") String name, Model model) {
        List<Product> productList = productService.findAllProduct(name);
        model.addAttribute("productList", productList);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String saveProduct(Product product) {
        product.setId(String.valueOf((int) (Math.random() * 1000)));
        productService.saveProduct(product);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable String id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(Product product) {
        productService.update(product.getId(), product);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam String id, Model model) {
        model.addAttribute("product", productService.delete(id));
        return "redirect:/";
    }

    @GetMapping("/detail")
    public String view(@RequestParam String id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "redirect:/";
    }
}
