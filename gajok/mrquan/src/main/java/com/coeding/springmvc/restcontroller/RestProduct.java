package com.coeding.springmvc.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coeding.springmvc.entity.Product;
import com.coeding.springmvc.service.ProductService;
import com.coeding.springmvc.serviceImpl.ProductServiceImpl;

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
}
