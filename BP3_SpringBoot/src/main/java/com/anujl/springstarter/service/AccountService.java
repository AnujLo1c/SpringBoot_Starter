package com.anujl.springstarter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.anujl.springstarter.models.Account;
import com.anujl.springstarter.repository.AccountRepository;
@Service
public class AccountService {
@Autowired
private AccountRepository accountRepository;

@Autowired
private PasswordEncoder passwordEncoder;

    public Account saveAccount(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.save(account);
    }
    
}
