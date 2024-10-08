package com.ecom.trip.holiday.service;

import com.ecom.trip.holiday.Product;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(@Valid Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(String productId) {
       productRepository.deleteById(productId);
    }
}
