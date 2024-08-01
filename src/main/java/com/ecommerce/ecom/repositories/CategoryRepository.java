package com.ecommerce.ecom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecom.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
