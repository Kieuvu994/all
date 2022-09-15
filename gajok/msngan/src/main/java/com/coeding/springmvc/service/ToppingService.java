package com.coeding.springmvc.service;

import java.util.List;


import com.coeding.springmvc.entity.Topping;


public interface ToppingService {
	
	
	Topping getSizeById(int id);

	List<Topping> listTopping();

	

	//int updateUser(ProductDto dto);
	
	//int createUser(ProductDto dto);
}
