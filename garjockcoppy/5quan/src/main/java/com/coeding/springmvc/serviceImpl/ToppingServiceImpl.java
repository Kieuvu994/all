package com.coeding.springmvc.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coeding.springmvc.entity.Topping;
import com.coeding.springmvc.dao.ToppingDao;
import com.coeding.springmvc.service.ToppingService;


/**
 * 
 * @author Quan
 *
 */

@Service
public class ToppingServiceImpl implements ToppingService{

	
	@Autowired
	ToppingDao toppingDao;
	
	
	@Override
	public Topping findById(int id) {
		
		return toppingDao.findById(id);
	}


	@Override
	public List<Topping> findAll() {
		
		return toppingDao.findAll();
	}

}
