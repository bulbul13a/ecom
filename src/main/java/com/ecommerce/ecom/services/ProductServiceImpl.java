package com.ecommerce.ecom.services;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.ecom.models.Product;
import com.ecommerce.ecom.models.ResponseMessage;
import com.ecommerce.ecom.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public ResponseEntity<?> add(Product product){
		if(Objects.isNull(product.getName())|| product.getName().trim().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Invalid Item"));
		}
		return ResponseEntity.ok(productRepository.save(product));
	}
	
	@Override
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(productRepository.findAll());
		
	}
	
	@Override
	public ResponseEntity<?> delete(Long id){
		Optional<Product> optionalExistingCategory = productRepository.findById(id);
		if(optionalExistingCategory.isPresent()){
			productRepository.deleteById(id);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Element deleted"));
	}
}
