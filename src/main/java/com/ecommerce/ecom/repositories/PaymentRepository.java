package com.ecommerce.ecom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecom.models.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{
	
}
