package com.anujl.blacknwhite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anujl.blacknwhite.models.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
   
    
} 
