package com.ecommerce.ecom.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ecommerce.ecom.models.AttributeInfo;

public interface AttributeInfoService {
	ResponseEntity<?> add(AttributeInfo attributeInfo);
	ResponseEntity<?> getAll();
	ResponseEntity<?> delete(Long id);
}
