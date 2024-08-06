package com.ecommerce.ecom.services;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.ecom.models.Customer;
import com.ecommerce.ecom.models.ResponseMessage;
import com.ecommerce.ecom.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public ResponseEntity<?> add(Customer customer){
		if(Objects.isNull(customer.getName()) || customer.getName().trim().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Invalid name"));
		}
		return ResponseEntity.ok(customerRepository.save(customer));
	}
	
	@Override
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(customerRepository.findAll());
		
	}
	
	@Override
	public ResponseEntity<?> delete(Long id){
		Optional<Customer> optionalExistingCategory = customerRepository.findById(id);
		if(optionalExistingCategory.isPresent()){
			customerRepository.deleteById(id);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Element deleted"));
	}
}
