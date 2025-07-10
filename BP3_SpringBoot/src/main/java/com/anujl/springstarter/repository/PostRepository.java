package com.anujl.springstarter.repository;

import org.springframework.stereotype.Repository;

import com.anujl.springstarter.models.Post;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    
    
    
    
}
