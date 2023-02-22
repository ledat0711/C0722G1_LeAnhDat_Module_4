package com.blog.repository;

import com.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    
    @Query(value = " select * from blog where name like :name and author like :author ", nativeQuery = true)
    Page<Blog> findAllByNameAndAuthor(Pageable pageable,@Param("name") String name,@Param("author") String author);

    @Query(
            value = "select * from blog where category_id = :categoryId",
            nativeQuery = true
    )
    List<Blog> searchByCategoryId(@Param("categoryId") Integer categoryId);
}
