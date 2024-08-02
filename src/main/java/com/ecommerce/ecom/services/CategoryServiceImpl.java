package com.ecommerce.ecom.services;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.ecom.models.Category;
import com.ecommerce.ecom.models.ResponseMessage;
import com.ecommerce.ecom.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public ResponseEntity<?> add(Category category){
		if(Objects.isNull(category.getName()) || category.getName().trim().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Invalid name"));
		}
		
		return ResponseEntity.ok(categoryRepository.save(category));
	}
	
	@Override
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(categoryRepository.findAll());
		
	}
	
	@Override
	public ResponseEntity<?> delete(Long id){
		Optional<Category> optionalExistingCategory = categoryRepository.findById(id);
		if(optionalExistingCategory.isPresent()){
			categoryRepository.deleteById(id);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Element deleted"));
	}
}
