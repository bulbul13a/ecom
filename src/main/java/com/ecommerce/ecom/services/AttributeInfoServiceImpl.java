package com.ecommerce.ecom.services;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ecommerce.ecom.models.AttributeInfo;
import com.ecommerce.ecom.models.ResponseMessage;
import com.ecommerce.ecom.repositories.AttributeInfoRepository;

public class AttributeInfoServiceImpl implements AttributeInfoService{
	@Autowired
	private AttributeInfoRepository attributeInfoRepository;
	
	@Override
	public ResponseEntity<?> addAttributeInfo(AttributeInfo attributeInfo){
		if(Objects.isNull(attributeInfo.getAttributeName())|| attributeInfo.getAttributeName().trim().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Invalid name"));
		}
		
		return ResponseEntity.ok(attributeInfoRepository.save(attributeInfo));
	}
	
	@Override
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(attributeInfoRepository.findAll());
		
	}
	
	@Override
	public ResponseEntity<?> delete(Long id){
		Optional<AttributeInfo> optionalExistingAttributeInfo = attributeInfoRepository.findById(id);
		if(optionalExistingAttributeInfo.isPresent()){
			attributeInfoRepository.deleteById(id);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Element deleted"));
	}

	@Override
	public ResponseEntity<?> update(Long id, AttributeInfo attributeInfo) {
		Optional<AttributeInfo> optionalExistingAI = attributeInfoRepository.findById(id);
		if(optionalExistingAI.isPresent()) {
			optionalExistingAI.get().setAttributeid(attributeInfo.getAttributeid());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Not Found"));
	}
}
