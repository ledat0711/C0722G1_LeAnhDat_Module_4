package com.blog.service;

import com.blog.model.Blog;
import com.blog.model.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    Category findById(Integer id);

    void delete(Integer id);
}
