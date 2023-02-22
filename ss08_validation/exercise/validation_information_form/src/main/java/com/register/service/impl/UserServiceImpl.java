package com.register.service.impl;

import com.register.model.User;
import com.register.repository.IUserRepository;
import com.register.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository IUserRepository;

    @Override
    public void add(User user) {
        IUserRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return IUserRepository.findAll();
    }
}
