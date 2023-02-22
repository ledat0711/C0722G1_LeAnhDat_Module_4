package com.product.repository;

import com.product.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAllProduct(String name);

    void saveProduct(Product product);

    Object findById(String id);

    void update(String id, Product product);

    Object delete(String id);

}
