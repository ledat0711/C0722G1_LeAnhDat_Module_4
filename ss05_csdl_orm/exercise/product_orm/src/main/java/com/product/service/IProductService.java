package com.product.service;

import com.product.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAllProduct(String name);

    void saveProduct(Product product);

    Object findById(int id);

    void update(Product product);

    Object delete(int id);
}
