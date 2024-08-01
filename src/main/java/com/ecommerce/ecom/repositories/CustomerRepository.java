package com.ecommerce.ecom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecom.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
