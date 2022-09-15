package com.coeding.springmvc.service;

import java.util.List;

import com.coeding.springmvc.entity.Size;


public interface SizeService {
	
	
	Size getSizeById(int id);

	List<Size> listSize();

	

	//int updateUser(ProductDto dto);
	
	//int createUser(ProductDto dto);
}
