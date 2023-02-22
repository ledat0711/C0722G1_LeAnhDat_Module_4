package com.dictionary.repository.impl;

import com.dictionary.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static Map<String, String> wordMap = new HashMap<>();

    static {
        wordMap.put("one", "một");
        wordMap.put("two", "hai");
        wordMap.put("three", "ba");
        wordMap.put("four", "bốn");
        wordMap.put("five", "năm");
    }

    @Override
    public String displayAnswer(String name) {
        String answerWord = wordMap.get(name);
        if (answerWord == null) {
            return "Không tìm thấy từ cần tìm";
        }
        return answerWord;
    }
}
