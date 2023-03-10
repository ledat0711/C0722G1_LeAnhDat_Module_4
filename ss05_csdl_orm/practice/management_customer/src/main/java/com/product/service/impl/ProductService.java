package com.product.service.impl;

import com.product.model.Product;
import com.product.repository.IProductRepository;
import com.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class    ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAllProduct(String name) {
        return productRepository.findAllProduct(name);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.saveProduct(product);
    }

    @Override
    public Object findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(String id, Product product) {
        productRepository.update(id, product);
    }

    @Override
    public Object delete(String id) {
        return productRepository.delete(id);
    }
}
