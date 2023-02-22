package com.email.service.impl;

import com.email.model.Email;
import com.email.repository.IEmailRepository;
import com.email.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService implements IEmailService{

    @Autowired
    IEmailRepository emailRepository;

    @Override
    public List<String> collectLanguage() {
        return emailRepository.collectLanguage();
    }

    @Override
    public List<String> collectPageSize() {
        return emailRepository.collectPageSize();
    }

    @Override
    public List<Email> showResultConfig(Email email) {
        return emailRepository.showResultConfig(email);
    }
}
