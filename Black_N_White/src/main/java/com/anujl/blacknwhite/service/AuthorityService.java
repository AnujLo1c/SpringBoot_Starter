package com.anujl.blacknwhite.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anujl.blacknwhite.models.Authority;
import com.anujl.blacknwhite.repository.AuthorityRepository;

@Service
public class AuthorityService {
    @Autowired
    private AuthorityRepository authorityRepository;

    public void saveAuthority(Authority authority) {
        if (authority.getId() != null && authorityRepository.existsById(authority.getId())) {
            Authority existing = authorityRepository.findById(authority.getId()).orElseThrow();
            existing.setPrivilage(authority.getPrivilage());
            authorityRepository.save(existing);
        } else {
            authorityRepository.save(authority);
        }
    }

    public Optional<Authority> findById(Long id) {
        return authorityRepository.findById(id);
    }
}
