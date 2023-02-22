package com.product.repository;

import com.product.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAllProduct(String name);

    void saveProduct(Product product);

    Object findById(int id);

    void update(Product product);

    Object delete(int id);

}
