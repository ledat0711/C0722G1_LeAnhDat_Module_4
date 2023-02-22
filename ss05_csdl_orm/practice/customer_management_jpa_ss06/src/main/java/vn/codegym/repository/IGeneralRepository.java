package vn.codegym.repository;

import vn.codegym.model.Customer;

import java.util.List;

public interface IGeneralRepository<T>{
    List<T> findAll();
    T findById(Long id);
    void save(T t);
    void remove(Long id);
}
