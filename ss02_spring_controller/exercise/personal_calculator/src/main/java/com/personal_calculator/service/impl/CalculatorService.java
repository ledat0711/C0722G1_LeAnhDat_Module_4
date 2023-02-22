package com.personal_calculator.service.impl;

import com.personal_calculator.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public String calculate(String action, double firstNum, double secondNum) {
        String answer = null;
        switch (action) {
            case "+":
                answer = (firstNum + secondNum) + "";
                break;
            case "-":
                answer = (firstNum - secondNum) + "";
                break;
            case "*":
                answer = (firstNum * secondNum) + "";
                break;
            case "/":
                if (secondNum == 0) {
                    return "cannot be divided by 0";
                } else {
                    answer = (firstNum / secondNum) + "";
                }
                break;
        }
        return answer;
    }
}
