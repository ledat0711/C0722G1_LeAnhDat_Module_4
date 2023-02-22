package com.email.service;

import com.email.model.Email;

import java.util.List;

public interface IEmailService {
    public List<String> collectLanguage();
    public List<String> collectPageSize();
    public List<Email> showResultConfig(Email email);
}
