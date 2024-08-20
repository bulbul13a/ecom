package com.ecommerce.ecom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecom.models.Blog;
import com.ecommerce.ecom.services.BlogService;

@RestController
@RequestMapping("/blog")
public class BlogController {
	@Autowired
	private BlogService blogService;
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> blog(@RequestBody Blog blog) {
		return blogService.addBlog(blog);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		return blogService.getAll();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateBlog(@PathVariable (name = "id") Long id,
			@RequestBody Blog blog){
		return blogService.update(id, blog);
	}
	
	@DeleteMapping("/delete/{id}") 
	 public ResponseEntity<?> deleteBlog(@PathVariable(name = "id") Long id) { 
		return blogService.delete(id);
	 }
}