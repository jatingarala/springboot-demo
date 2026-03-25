package com.test.demo.controller;


import com.test.demo.model.Product;
import com.test.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService service;

    /*
    http://localhost:8080/api/v1/products
    {
        "id":"2",
        "name":"product 2",
        "quantity":20,
        "price":5000
    }
     */
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    //http://localhost:8080/api/v1/products
    @GetMapping
    public List<Product> findAllProducts() {
        return List.of(
                new Product(1, "Test Product 1", 10, 1000.0),
                new Product(2, "Test Product 2", 20, 2000.0),
                new Product(3, "Test Product 3", 30, 3000.0)
        );
    }

    //http://localhost:8080/api/v1/products/1
    @GetMapping("{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    /*
    http://localhost:8080/api/v1/products
    {
        "id":"2",
        "name":"product 223",
        "quantity":20,
        "price":5000
    }
     */
    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

//    http://localhost:8080/api/v1/products/2
    @DeleteMapping("{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}