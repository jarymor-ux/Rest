package com.ostap.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ostap.rest.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
}
