package com.anujl.blacknwhite.repository;

import org.springframework.stereotype.Repository;

import com.anujl.blacknwhite.models.Post;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    
    
    
    
}
