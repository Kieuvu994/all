package com.coeding.springmvc.service;

import java.util.List;

import com.coeding.springmvc.entity.Order;


/**
 * 
 * @author Quan
 *
 */
public interface OrderService {
	Order findById(int id);
	List<Order> findAll();
}
