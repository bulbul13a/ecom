package com.ecommerce.ecom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecom.models.AttributeInfo;

@Repository
public interface AttributeInfoRepository extends JpaRepository<AttributeInfo, Long>{

}
