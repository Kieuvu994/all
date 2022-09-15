package com.coeding.springmvc.service;

import java.util.List;

import com.coeding.springmvc.entity.Product;


public interface ProductService {
	
	
	Product getProductById(int id);

	List<Product> listProduct();

	int deleteUser(Integer id);

	List<Product> listLastProduct();
	
	List<Product> listTopRatedProduct();
	
	List<Product> listTopReviewProduct();
	
	List<Product> listProductByCategory(int id);
	
	List<Product> listSearchProduct(String txt);
	
	List<Product> getProductPaging(int currentPage, int itemsPerPage);
	
	int countProduct();
	
	int[] countPage();
	
	//int createUser(ProductDto dto);
}
