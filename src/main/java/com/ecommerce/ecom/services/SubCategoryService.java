package com.ecommerce.ecom.services;

import org.springframework.http.ResponseEntity;

import com.ecommerce.ecom.models.SubCategory;

public interface SubCategoryService {
	ResponseEntity<?> add(SubCategory subCategory);
	ResponseEntity<?> getAll();
	ResponseEntity<?> delete(Long id);
}
