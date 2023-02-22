package com.blog.controller;

import com.blog.model.Category;
import com.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categoryRest")
public class CategoryRestController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("/listCategory")
    public ResponseEntity<List<Category>> goCategory() {
        List<Category> categoryList= categoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
    @GetMapping("/detailCategory")
    public  ResponseEntity<Category> goDetail(@RequestParam Integer id){
        Category category = categoryService.findById(id);
        if (category == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
