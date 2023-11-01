package com.ostap.rest.repository;

import java.util.LinkedList;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ostap.rest.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
}
