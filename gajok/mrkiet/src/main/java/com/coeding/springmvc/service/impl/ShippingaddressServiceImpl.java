package com.coeding.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coeding.springmvc.entity.Shippingaddressz;
import com.coeding.springmvc.model.ShippingAddressModel;
import com.coeding.springmvc.repository.ShippingaddressRepository;
import com.coeding.springmvc.service.ShippingaddressService;

@Service
public class ShippingaddressServiceImpl implements ShippingaddressService {
	
	@Autowired
	private ShippingaddressRepository shippingaddresszRepository;

	@Override
	public Shippingaddressz findById(int id) {
		// TODO Auto-generated method stub
		return this.shippingaddresszRepository.findById(id);
	}

	@Override
	public List<Shippingaddressz> findAll() {
		// TODO Auto-generated method stub
		return this.shippingaddresszRepository.findAll();
	}

	@Override
	public String create(Shippingaddressz pojo) {
		// TODO Auto-generated method stub
		return this.shippingaddresszRepository.create(pojo);
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		return this.shippingaddresszRepository.delete(id);
	}

	@Override
	public void create(ShippingAddressModel ship) {
		// TODO Auto-generated method stub
		this.shippingaddresszRepository.create(ship);
	}

	@Override
	public Shippingaddressz findShippingAddressByOrderID(int id) {
		// TODO Auto-generated method stub
		return this.shippingaddresszRepository.findShippingAddressByOrderID(id);
	}

}