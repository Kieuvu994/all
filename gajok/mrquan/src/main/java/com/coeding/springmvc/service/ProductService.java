package com.coeding.springmvc.service;

import java.util.List;

import com.coeding.springmvc.entity.Product;

/**
 * 
 * @author Quan
 *
 */

public interface ProductService {
	
	
	Product getProductById(Integer id);

	List<Product> listProduct();

	List<Product> findByCategory(int categoryId);
	
	List<Product> findByName(String name);
	
	int addProductz(Product product);
	
	int updateCountInStock(int id);
	
	int updateProduct(int id);
	
	void delete(int id);
	
	Product findRecent();

	
}
