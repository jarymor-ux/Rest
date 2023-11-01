package com.ostap.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ostap.rest.entity.Product;
import com.ostap.rest.entity.User;
import com.ostap.rest.repository.ProductRepository;
import com.ostap.rest.repository.UserRepository;


@RestController
@RequestMapping("/api")
public class MainController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getAllProducts")
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    
    @PostMapping("/addNewProduct")
    public Product addProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping("/getUsers")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/getUsers/{id}")
    public User getUserById(@PathVariable int id){
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping("/addNewUser")
    public User addNewUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @PostMapping("/setUserProd/{id}")
    public Product setUserProd(@RequestBody Product product, @PathVariable int id){
        User user = userRepository.getById(id);
        addProduct(product);
        product.setUser(user);
        return productRepository.save(product);
    }

}
