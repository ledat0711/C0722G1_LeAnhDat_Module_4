package com.email.repository.impl;

import com.email.model.Email;
import com.email.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository {
    private static final List<Email> emailList = new ArrayList<>();
    private static final List<String> languageList = new ArrayList<>();
    private static final List<String> pageSizeList = new ArrayList<>();
    static {
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
    }
    static {
        pageSizeList.add("5");
        pageSizeList.add("10");
        pageSizeList.add("15");
        pageSizeList.add("25");
        pageSizeList.add("50");
        pageSizeList.add("100");
    }

    @Override
    public List<String> collectLanguage() {
        return languageList;
    }

    @Override
    public List<String> collectPageSize() {
        return pageSizeList;
    }

    @Override
    public List<Email> showResultConfig(Email email) {
        emailList.add(email);
        return emailList;
    }
}
