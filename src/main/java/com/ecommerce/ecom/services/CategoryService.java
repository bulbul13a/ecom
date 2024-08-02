package com.ecommerce.ecom.services;

import org.springframework.http.ResponseEntity;

import com.ecommerce.ecom.models.Category;

public interface CategoryService {
	ResponseEntity<?> add(Category category);
	ResponseEntity<?> getAll();
	ResponseEntity<?> delete(Long id);
}
