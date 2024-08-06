package com.ecommerce.ecom.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.ecom.models.OrderItem;
import com.ecommerce.ecom.models.ResponseMessage;
import com.ecommerce.ecom.repositories.OrderItemRepository;

@Service
public class OrderItemServiceImpl implements OrderItemService{
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public ResponseEntity<?> add(OrderItem orderItem){
		if(orderItem.getOrderItemID()== null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Invalid Item"));
		}
		return ResponseEntity.ok(orderItemRepository.save(orderItem));
	}
	
	@Override
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(orderItemRepository.findAll());
		
	}
	
	@Override
	public ResponseEntity<?> delete(Long id){
		Optional<OrderItem> optionalExistingCategory = orderItemRepository.findById(id);
		if(optionalExistingCategory.isPresent()){
			orderItemRepository.deleteById(id);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Element deleted"));
	}
}
