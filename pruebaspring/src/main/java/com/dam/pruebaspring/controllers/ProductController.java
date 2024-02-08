package com.dam.pruebaspring.controllers;

import com.dam.pruebaspring.models.Product;
import com.dam.pruebaspring.servicies.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/by-id/{id}")
    public Product getProduct(@PathVariable Integer id) {
        return productService.getProductById(id);
    }
}
