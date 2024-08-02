package com.ecommerce.ecom.services;

import org.springframework.http.ResponseEntity;

import com.ecommerce.ecom.models.OrderItem;

public interface OrderItemService {
	ResponseEntity<?> add(OrderItem orderItem);
	ResponseEntity<?> getAll();
	ResponseEntity<?> delete(Long id);
}
