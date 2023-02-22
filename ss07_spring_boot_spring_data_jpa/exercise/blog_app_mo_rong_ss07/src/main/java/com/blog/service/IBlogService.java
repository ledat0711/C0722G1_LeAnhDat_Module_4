package com.blog.service;

import com.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {

    void save(Blog blog);

    Blog findById(Integer id);

    void delete(Integer id);

    Page<Blog> findAll(Pageable pageable, String name, String author);
}
