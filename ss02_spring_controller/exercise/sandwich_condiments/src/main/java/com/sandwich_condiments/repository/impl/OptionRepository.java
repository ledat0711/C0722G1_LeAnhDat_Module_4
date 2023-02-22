package com.sandwich_condiments.repository.impl;

import com.sandwich_condiments.repository.IOptionRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OptionRepository implements IOptionRepository {
    private static final List<String> optionList = new ArrayList<>();

    static {
        optionList.add("Lettuce");
        optionList.add("Tomoto");
        optionList.add("Mustard");
        optionList.add("Sp");
    }

    @Override
    public List<String> listOption() {
        return optionList;
    }
}
