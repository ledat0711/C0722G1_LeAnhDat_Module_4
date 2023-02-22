package com.register.service;

import com.register.model.User;

import java.util.List;

public interface IUserService {
    void add(User user);
    List<User> findAll() ;
}
