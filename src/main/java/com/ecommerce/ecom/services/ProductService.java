package com.ecommerce.ecom.services;

import org.springframework.http.ResponseEntity;

import com.ecommerce.ecom.models.Product;

public interface ProductService {
	ResponseEntity<?> add(Product product);
	ResponseEntity<?> getAll();
	ResponseEntity<?> delete(Long id);
}
