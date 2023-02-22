package com.blog.controller;

import com.blog.model.Blog;
import com.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog-restful")
public class
BlogRestController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/list")
    public ResponseEntity<Page<Blog>> goPage(@PageableDefault(5) Pageable pageable,
                                             @RequestParam Optional<String> name,
                                             @RequestParam Optional<String> author) {

        String keyName = name.orElse("");
        String keyAuthor = author.orElse("");
        Page<Blog> blogPage = blogService.findAll(pageable,keyName,keyAuthor);
        if (!blogPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @GetMapping("/detail")
    public ResponseEntity<Blog> goDetail(@RequestParam Integer id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Page<Void>> create(@RequestBody Blog blog) {
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search-by-category-id/{categoryId}")
    public ResponseEntity<List<Blog>> getListBlogBasedOnCategoryId(@PathVariable("categoryId") Integer categoryId) {
        List<Blog> listBlog = blogService.searchByCategoryId(categoryId);
        return new ResponseEntity<>(listBlog, HttpStatus.OK);
    }

}
