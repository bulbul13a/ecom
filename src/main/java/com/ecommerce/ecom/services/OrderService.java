package com.ecommerce.ecom.services;

import org.springframework.http.ResponseEntity;

import com.ecommerce.ecom.models.Order;

public interface OrderService {
	ResponseEntity<?> add(Order order);
	ResponseEntity<?> getAll();
	ResponseEntity<?> delete(Long id);
}
