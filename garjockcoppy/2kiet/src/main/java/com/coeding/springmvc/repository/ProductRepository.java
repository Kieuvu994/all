package com.coeding.springmvc.repository;

import java.util.List;

import com.coeding.springmvc.entity.Productz;

public interface ProductRepository {
	Productz findById(int id);
	List<Productz> findAll();
	String create(Productz pojo);
	String update(Productz pojo);
	String delete(int id);
	
	
	List<Productz> findAllProductByCategoryId(int id);
	List<Productz> findByKeywords(String keywords);
 	List<Productz> findItemByHot(String key);
 	List<Productz> findByIdsInCookie(String id);
}
