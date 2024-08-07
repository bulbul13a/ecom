package com.ecommerce.ecom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return attributeInfoService.getAll();
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody AttributeInfo attributeInfo){
    	return attributeInfoService.add(attributeInfo);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable (name = "id"))
}
