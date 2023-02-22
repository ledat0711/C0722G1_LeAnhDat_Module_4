package com.blog.service;

import com.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    void save(Blog blog);

    Blog findById(Integer id);

    void delete(Integer id);

    Page<Blog> findAll(Pageable pageable, String name, String author);

    List<Blog> searchByCategoryId(Integer categoryId);
}
