package com.email.repository;

import com.email.model.Email;

import java.util.List;

public interface IEmailRepository {
    public List<String> collectLanguage();
    public List<String> collectPageSize();
    public List<Email> showResultConfig(Email email);
}
