package com.ecommerce.ecom.services;

import org.springframework.http.ResponseEntity;

import com.ecommerce.ecom.models.Customer;

public interface CustomerService {
	ResponseEntity<?> add(Customer customer);
	ResponseEntity<?> getAll();
	ResponseEntity<?> delete(Long id);
}
