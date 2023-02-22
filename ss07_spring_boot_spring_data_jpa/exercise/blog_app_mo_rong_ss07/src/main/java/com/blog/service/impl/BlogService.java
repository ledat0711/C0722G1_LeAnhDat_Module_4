package com.blog.service.impl;

import com.blog.model.Blog;
import com.blog.repository.IBlogRepository;
import com.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(new Blog());
    }

    @Override
    public void delete(Integer id) {
        blogRepository.delete(findById(id));
    }


    @Override
    public Page<Blog> findAll(Pageable pageable, String name, String author) {
        return this.blogRepository.findAllByNameAndAuthor(pageable, "%" + name + "%", "%" + author + "%");
    }
}
