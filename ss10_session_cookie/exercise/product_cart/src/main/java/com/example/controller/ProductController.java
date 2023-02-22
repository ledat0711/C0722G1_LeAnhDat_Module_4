package com.example.controller;

import com.example.dto.CartDto;
import com.example.dto.ProductDto;
import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@SessionAttributes("cart")
@Controller
@RequestMapping("/shop")
public class ProductController {
    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @Autowired
    private IProductService iProductService;

    @GetMapping
    public String showListPage(Model model,
                               @CookieValue(value = "idProduct", defaultValue = "-1") Integer idProduct) {
        if (idProduct != -1) {
            model.addAttribute("historyProduct", iProductService.findById(idProduct).get());
        }
        model.addAttribute("productList", iProductService.findAll());
        return "product/list";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable Integer id, HttpServletResponse response, Model model) {
        Cookie cookie = new Cookie("idProduct", id + "");
        cookie.setMaxAge(24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
        model.addAttribute("product", iProductService.findById(id).get());
        return "product/detail";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Integer id, @SessionAttribute("cart") CartDto cart) {
        Optional<Product> productDetail = iProductService.findById(id);

        if (productDetail.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productDetail.get(), productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("/decrease/{id}")
    public String decreaseToCart(@PathVariable Integer id, @SessionAttribute("cart") CartDto cart) {
        Optional<Product> productDetail = iProductService.findById(id);
        if (productDetail.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productDetail.get(), productDto);
            cart.decreaseProduct(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("/delete/{id}")
    public String deleteProductIn(@PathVariable Integer id, @SessionAttribute("cart") CartDto cart) {
        Optional<Product> productDetail = iProductService.findById(id);
        if (productDetail.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productDetail.get(), productDto);
            cart.remove(productDto);
        }
        return "redirect:/cart";
    }
}
