package com.coeding.springmvc.repository;

import java.util.List;

import com.coeding.springmvc.entity.Orderz;
import com.coeding.springmvc.entity.Userz;
import com.coeding.springmvc.model.OrderModel;
import com.coeding.springmvc.service.CartService;

public interface OrderRepository {
	Orderz findById(int id);
	List<Orderz> findAll();
	String create(Orderz pojo);
	String delete(int id);
	Orderz takeID();
	
	void createOrderDetail(Orderz o);
	List<Orderz> findByUser(Userz user);
	void createModel(OrderModel model);
}
