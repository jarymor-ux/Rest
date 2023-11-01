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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(tags = "API")
public class MainController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/getAllProducts")
    @ApiOperation("Get all products in db")
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    
    @PostMapping("/addNewProduct")
    @ApiOperation("Add 1 product to the db using JSON post query")
    public Product addProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping("/getUsers")
    @ApiOperation("Get all users in db")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/getUsers/{id}")
    @ApiOperation("Get 1 user from the db")
    public User getUserById(@PathVariable int id){
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping("/addNewUser")
    @ApiOperation("Add 1 User to the db using JSON post query")
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
