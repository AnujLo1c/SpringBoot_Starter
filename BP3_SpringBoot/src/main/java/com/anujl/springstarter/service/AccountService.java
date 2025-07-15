package com.anujl.springstarter.service;

import java.util.ArrayList;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.anujl.springstarter.models.Account;
import com.anujl.springstarter.models.Authority;
import com.anujl.springstarter.repository.AccountRepository;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
@Service
public class AccountService implements UserDetailsService {
@Autowired
private AccountRepository accountRepository;

@Autowired
private PasswordEncoder passwordEncoder;

    public Account saveAccount(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        // account.setRole(Roles.USER.getRole());
        return accountRepository.save(account);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(email);
        if (account == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(account.getRole()));
        for(Authority authority : account.getPrivilages()) {
            authorities.add(new SimpleGrantedAuthority(authority.getPrivilage()));
        }
        return new User(account.getEmail(), account.getPassword(), authorities);
    }
    
    public Account getCurrentAccount(String email) {
        return accountRepository.findByEmail(email);
    }
}
