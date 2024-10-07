package com.ecom.trip.holiday.controller;

import com.ecom.trip.holiday.Product;
import com.ecom.trip.holiday.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products")
    public List<Product> getAllProducts() {
        System.out.println("get products");
        return productService.getAllProducts();
    }

    @PostMapping(value = "/products")
    public ResponseEntity<String> addProduct(@Valid @RequestBody Product product) {
        productService.addProduct(product);
        return ResponseEntity.ok("Product is created successfully");
    }

    @PutMapping(value = "/products/{id}")
    public ResponseEntity<Product> updateEmployee (@PathVariable("id") int id, @Valid @RequestBody Product product)
    {
        productService.updateProduct(product);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @DeleteMapping(value = "/products/{id}")
    public ResponseEntity<HttpStatus> deleteProduct (@PathVariable("id") String id)
    {
        Optional<Product> existingProduct = this.productService.findById(id);
        if(existingProduct.isPresent()){
            System.out.println("Yes present");
            productService.deleteProduct(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
