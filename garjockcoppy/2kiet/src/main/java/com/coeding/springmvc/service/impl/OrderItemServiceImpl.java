package com.coeding.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coeding.springmvc.entity.Orderitemz;
import com.coeding.springmvc.model.OrderItemModel;
import com.coeding.springmvc.repository.OrderItemRepository;
import com.coeding.springmvc.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public Orderitemz findById(int id) {
		// TODO Auto-generated method stub
		return this.orderItemRepository.findById(id);
	}

	@Override
	public List<Orderitemz> findAll() {
		// TODO Auto-generated method stub
		return this.orderItemRepository.findAll();
	}

	@Override
	public String create(Orderitemz pojo) {
		// TODO Auto-generated method stub
		return this.orderItemRepository.create(pojo);
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		return this.orderItemRepository.delete(id);
	}

	@Override
	public void create(OrderItemModel s) {
		// TODO Auto-generated method stub
		this.orderItemRepository.create(s);
	}

	@Override
	public List<Orderitemz> findOrderItemByOrderID(int id) {
		// TODO Auto-generated method stub
		return this.orderItemRepository.findOrderItemByOrderID(id);
	}

}