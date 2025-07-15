package com.anujl.springstarter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anujl.springstarter.models.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
   
    
} 
