package com.ecommerce.ecom.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.ecom.models.Payment;
import com.ecommerce.ecom.models.ResponseMessage;
import com.ecommerce.ecom.repositories.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public ResponseEntity<?> add(Payment payment){
		if(payment.getPaymentID()== null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Invalid Item"));
		}
		return ResponseEntity.ok(paymentRepository.save(payment));
	}
	
	@Override
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(paymentRepository.findAll());
		
	}
	
	@Override
	public ResponseEntity<?> delete(Long id){
		Optional<Payment> optionalExistingCategory = paymentRepository.findById(id);
		if(optionalExistingCategory.isPresent()){
			paymentRepository.deleteById(id);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Element deleted"));
	}
}
