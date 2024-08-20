package com.ecommerce.ecom.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.ecom.models.Blog;


public interface BlogService {
	ResponseEntity<?> addBlog(Blog blog);
	ResponseEntity<?> getAll();
	ResponseEntity<?> delete(Long id);
	ResponseEntity<?> update(Long id, Blog blog);
	ResponseEntity<?> addBlog(Blog blog, List<MultipartFile> files);
}
