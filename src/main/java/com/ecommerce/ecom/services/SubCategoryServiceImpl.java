package com.ecommerce.ecom.services;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ecommerce.ecom.models.SubCategory;
import com.ecommerce.ecom.models.ResponseMessage;
import com.ecommerce.ecom.repositories.SubCategoryRepository;

public class SubCategoryServiceImpl implements SubCategoryService{
	@Autowired
	private SubCategoryRepository subCategoryRepository;
	
	@Override
	public ResponseEntity<?> add(SubCategory subCategory){
		if(Objects.isNull(subCategory.getName())|| subCategory.getName().trim().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Invalid name"));
		}
		
		return ResponseEntity.ok(subCategoryRepository.save(subCategory));
	}
	
	@Override
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(subCategoryRepository.findAll());
		
	}
	
	@Override
	public ResponseEntity<?> delete(Long id){
		Optional<SubCategory> optionalExistingAttributeInfo = subCategoryRepository.findById(id);
		if(optionalExistingAttributeInfo.isPresent()){
			subCategoryRepository.deleteById(id);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Element deleted"));
	}
}
