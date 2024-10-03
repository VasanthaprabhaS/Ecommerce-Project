package com.ecom.trip.holiday.service;

import com.ecom.trip.holiday.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
