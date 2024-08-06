package com.ecommerce.ecom.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.ecom.models.Order;
import com.ecommerce.ecom.models.ResponseMessage;
import com.ecommerce.ecom.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public ResponseEntity<?> add(Order order){
		if(order.getOrderID()== null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Invalid Item"));
		}
		return ResponseEntity.ok(orderRepository.save(order));
	}
	
	@Override
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(orderRepository.findAll());
		
	}
	
	@Override
	public ResponseEntity<?> delete(Long id){
		Optional<Order> optionalExistingCategory = orderRepository.findById(id);
		if(optionalExistingCategory.isPresent()){
			orderRepository.deleteById(id);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Element deleted"));
	}
}
