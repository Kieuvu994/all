package com.coeding.springmvc.service;

import java.util.List;
import java.util.Map;

import com.coeding.springmvc.entity.Orderz;
import com.coeding.springmvc.entity.Productz;
import com.coeding.springmvc.model.OrderModel;

public interface OrderService {
	Orderz findById(int id);
	List<Orderz> findAll();
	String delete(int id);
	
	Orderz takeID();
	
	Orderz createOrder(Orderz o);
	void addOrderAndOrderDetail(Orderz o); // thêm mới đơn hàng vào db
	List<Orderz> getAllOrderByUser();
	Orderz findById(Integer id);
	Map<Integer, Productz> getPurchasedItems();
	void createModel(OrderModel model);
}
