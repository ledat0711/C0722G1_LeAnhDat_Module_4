package com.sandwich_condiments.service.impl;

import com.sandwich_condiments.repository.IOptionRepository;
import com.sandwich_condiments.service.IOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService implements IOptionService {

    @Autowired
    private IOptionRepository optionRepository;

    @Override
    public List<String> listOption() {
        return optionRepository.listOption();
    }
}
