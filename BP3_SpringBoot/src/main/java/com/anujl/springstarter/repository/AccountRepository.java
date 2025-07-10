package com.anujl.springstarter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anujl.springstarter.models.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	
} 
