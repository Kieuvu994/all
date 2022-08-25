package com.coeding.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coeding.springmvc.dao.ToppingDao;
import com.coeding.springmvc.entity.Topping;
import com.coeding.springmvc.service.ToppingService;

@Service
public class ToppingServiceImpl implements ToppingService {

	@Autowired
	private ToppingDao dao;
	
	@Override
	public Topping getSizeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Topping> listTopping() {
		// TODO Auto-generated method stub
		return dao.getAllTopping();
	}

}
