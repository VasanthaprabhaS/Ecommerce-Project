package com.ecom.trip.holiday.service;

import com.ecom.trip.holiday.bo.Product;
import com.ecom.trip.holiday.exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product findById(String id) {
        return productRepository.findById(id)
                .orElseThrow(
                ()-> new ResourceNotFoundException());
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
