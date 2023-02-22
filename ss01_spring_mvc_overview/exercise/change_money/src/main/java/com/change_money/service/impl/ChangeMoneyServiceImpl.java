package com.change_money.service.impl;

import com.change_money.service.IChangeMoneyService;
import org.springframework.stereotype.Service;

@Service
public class ChangeMoneyServiceImpl implements IChangeMoneyService {
    @Override
    public double changeMoney(double usd) {
        return 23000 * usd;
    }
}
