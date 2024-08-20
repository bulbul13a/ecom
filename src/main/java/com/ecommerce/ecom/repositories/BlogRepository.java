package com.ecommerce.ecom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.ecom.models.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long>{

}