package com.anujl.springstarter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anujl.springstarter.models.Account;
import com.anujl.springstarter.repository.AccountRepository;
@Service
public class AccountService {
@Autowired
private AccountRepository accountRepository;


    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }
    
}
