package com.coeding.springmvc.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coeding.springmvc.entity.Order;
import com.coeding.springmvc.dao.OrderDao;
import com.coeding.springmvc.service.OrderService;


/**
 * 
 * @author Quan
 *
 */

@Service
public class OrderServiceImpl implements OrderService{

	
	@Autowired
	OrderDao orderDao;
	
	@Override
	public Order findById(int id) {
		
		return orderDao.findById(id);
	}

	@Override
	public List<Order> findAll() {
		
		return orderDao.findAll();
	}

}
