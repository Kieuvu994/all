package com.coeding.springmvc.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coeding.springmvc.entity.Product;
import com.coeding.springmvc.entity.User;
import com.coeding.springmvc.service.ProductService;
import com.coeding.springmvc.service.impl.ProductServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class RestProduct {
    @Autowired
	private ProductServiceImpl service;
    
    @GetMapping("/products/list")
	public List<Product> listProduct(){
		return service.listProduct();
		
	}
    
    @GetMapping("/products/{id}")
	public Product getProductById(@PathVariable("id") int id ) {
		return service.getProductById(id);
	}
}
