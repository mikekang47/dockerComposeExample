package com.example.helloworld.applictaions;

import com.example.helloworld.domains.Product;
import com.example.helloworld.dto.ProductRequestData;
import com.example.helloworld.infra.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PRODUCT NOT FOUND**********"));
    }

    public Product createProduct(ProductRequestData productRequestData) {
        Product product = new Product(productRequestData.getName());
        return productRepository.save(product);
    }
}
