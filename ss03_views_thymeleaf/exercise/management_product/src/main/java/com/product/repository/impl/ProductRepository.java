package com.product.repository.impl;

import com.product.model.Product;
import com.product.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class ProductRepository implements IProductRepository {
    private static final Map<Integer, Product> INTEGER_PRODUCT_MAP = new HashMap<>();
    static {
        INTEGER_PRODUCT_MAP.put(1, new Product(1,"Bút bi",10,"bút bi xanh","Alpha"));
        INTEGER_PRODUCT_MAP.put(2, new Product(2,"Vở",20,"vở 96 trang","Apple"));
        INTEGER_PRODUCT_MAP.put(3, new Product(3,"Phấn",30,"phấn không bụi","Toyota"));
        INTEGER_PRODUCT_MAP.put(4, new Product(4,"Bút mực",40,"Bút mực kim tinh","Thiên Long"));
        INTEGER_PRODUCT_MAP.put(5, new Product(5,"Bút chì",50,"Bút chì đậm","Siemens"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(INTEGER_PRODUCT_MAP.values());
    }

    @Override
    public void save(Product product) {
        INTEGER_PRODUCT_MAP.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return INTEGER_PRODUCT_MAP.get(id);
    }
    @Override
    public void update(int id, Product product) {
        INTEGER_PRODUCT_MAP.put(id,product);
    }

    @Override
    public void remove(int id) {
        INTEGER_PRODUCT_MAP.remove(id);
    }

    @Override
    public List<Product> listBySearchName(String name) {
        List<Product> productsFoundByName = new ArrayList<>();
        for (Product product : INTEGER_PRODUCT_MAP.values()){
            if(product.getName().contains(name)){
                productsFoundByName.add(product);
            }
        }
        return productsFoundByName;
    }
}
