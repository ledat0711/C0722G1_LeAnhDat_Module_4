package com.product.repository.impl;

import com.product.model.Product;
import com.product.repository.BaseRepository;
import com.product.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static final String SELECT_ALL_PRODUCT = "select p from Product p";
    private static final String SELECT_BY_ID = "select p from Product p where p.id = :id";

    @Override
    public List<Product> findAllProduct(String name) {
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery(SELECT_ALL_PRODUCT, Product.class);
        if (name == null) {
            return query.getResultList();
        } else {
            List<Product> productList = new ArrayList<>();
            for (Product product : query.getResultList()) {
                if (product.getName().contains(name)) {
                    productList.add(product);
                }
            }
            return productList;
        }
    }

    @Override
    public void saveProduct(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Object findById(int id) {
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery(SELECT_BY_ID, Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();

    }

    @Override
    public void update(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public Object delete(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(BaseRepository.entityManager.find(Product.class, id));
        entityTransaction.commit();
        return null;
    }
}