package com.ssmTest.service;

import com.ssmTest.mapper.AccountMapper;
import com.ssmTest.model.Account;
import com.ssmTest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    public Account selectByPassword(Account account) {
        return accountMapper.selectByPassword(account);
    }

    public User selectById(int id) {
        return accountMapper.selectById(id);
    }
}
