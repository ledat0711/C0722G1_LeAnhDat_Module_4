package com.blog.repository;

import com.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = " select * from blog where name like :search ", nativeQuery = true)
    Page<Blog> findAllByName(Pageable pageable,@Param("search") String search); 

    @Query(value = " select * from blog where name like :name and author like :author ", nativeQuery = true)
    Page<Blog> findAllByNameAndAuthor(Pageable pageable,@Param("name") String name,@Param("author") String author);
}
