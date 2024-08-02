package com.ecommerce.ecom.services;

import org.springframework.http.ResponseEntity;

import com.ecommerce.ecom.models.Payment;

public interface PaymentService {
	ResponseEntity<?> add(Payment payment);
	ResponseEntity<?> getAll();
	ResponseEntity<?> delete(Long id);
}
