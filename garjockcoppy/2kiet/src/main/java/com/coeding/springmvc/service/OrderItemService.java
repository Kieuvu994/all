package com.coeding.springmvc.service;

import java.util.List;

import com.coeding.springmvc.entity.Orderitemz;
import com.coeding.springmvc.model.OrderItemModel;

public interface OrderItemService {
	Orderitemz findById(int id);
	List<Orderitemz> findAll();
	String create(Orderitemz pojo);
	String delete(int id);
	void create(OrderItemModel s);
	
	List<Orderitemz> findOrderItemByOrderID(int id);
}