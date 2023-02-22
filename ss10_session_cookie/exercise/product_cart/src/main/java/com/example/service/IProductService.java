package com.example.service;

import com.example.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();

    Optional<Product> findById(Integer id);

    void save(Product product);
}
