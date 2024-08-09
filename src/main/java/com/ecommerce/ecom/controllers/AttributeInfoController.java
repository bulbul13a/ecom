package com.ecommerce.ecom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecom.models.AttributeInfo;
import com.ecommerce.ecom.services.AttributeInfoService;

@RestController
@RequestMapping("/attribute_info")
public class AttributeInfoController {
	@Autowired
	private AttributeInfoService attributeInfoService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addAttributeInfo(@RequestBody AttributeInfo attributeInfo) {
		return attributeInfoService.addAttributeInfo(attributeInfo);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		return attributeInfoService.getAll();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUser(@PathVariable (name = "id") Long id,
			@RequestBody AttributeInfo attributeInfo){
		return attributeInfoService.update(id, attributeInfo);
	}
	
	@DeleteMapping("/delete/{id}") 
	 public ResponseEntity<?> deleteUser(@PathVariable(name = "id") Long id) { 
	        // Delete the user in this method with the id.
		return attributeInfoService.delete(id);
	 }
}
