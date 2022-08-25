package com.coeding.springmvc.service;

import java.util.List;


import com.coeding.springmvc.entity.Topping;

/**
 * 
 * @author Quan
 *
 */

public interface ToppingService {
	Topping findById(int id);
	List<Topping> findAll();
}
