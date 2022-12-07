package com.example.helloworld.controllers;

import com.example.helloworld.applictaions.ProductService;
import com.example.helloworld.domains.Product;
import com.example.helloworld.dto.ProductRequestData;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping ("/{id}")
    public Product detail(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PostMapping
    public Product create(@RequestBody ProductRequestData productRequestData) {
        return productService.createProduct(productRequestData);

    }
}
