package com.coeding.springmvc.service;

import java.util.List;
import java.util.Optional;

import com.coeding.springmvc.dto.ProductDTO;
import com.coeding.springmvc.entity.Productz;


public interface ProductService {
	
	Optional<Productz> findById(int id);
	List<Productz> findAll();
	String create(Productz pojo);
	String update(Productz pojo);
	String delete(int id);
	
	List<Productz> findAllProductByCategoryId(int id);
	
//	Product getProductById(int id);
//
//	List<Product> listProduct();
//
//	int deleteUser(Integer id);

	//int updateUser(ProductDto dto);
	
	//int createUser(ProductDto dto);
}
