package com.codegym.service.impl;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerService implements ICustomerService {
    private static final Map<Integer, Customer> INTEGER_CUSTOMER_MAP = new HashMap<>();
    static {
        INTEGER_CUSTOMER_MAP.put(1, new Customer(1,"John","john@codegym.vn","Hanoi"));
        INTEGER_CUSTOMER_MAP.put(2, new Customer(2,"Bill","bill@codegym.vn","Danang"));
        INTEGER_CUSTOMER_MAP.put(3, new Customer(3,"Alex","alex@codegym.vn","Saigon"));
        INTEGER_CUSTOMER_MAP.put(4, new Customer(4,"Adam","adam@codegym.vn","Beijing"));
        INTEGER_CUSTOMER_MAP.put(5, new Customer(5,"Rose","rose@codegym.vn","Newyork"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(INTEGER_CUSTOMER_MAP.values());
    }

    @Override
    public void save(Customer customer) {
        INTEGER_CUSTOMER_MAP.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return INTEGER_CUSTOMER_MAP.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        INTEGER_CUSTOMER_MAP.put(id,customer);
    }

    @Override
    public void remove(int id) {
        INTEGER_CUSTOMER_MAP.remove(id);
    }
}
