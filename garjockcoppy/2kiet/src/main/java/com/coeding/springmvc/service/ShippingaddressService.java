package com.coeding.springmvc.service;

import java.util.List;

import com.coeding.springmvc.entity.Shippingaddressz;
import com.coeding.springmvc.model.ShippingAddressModel;

public interface ShippingaddressService {
	Shippingaddressz findById(int id);
	List<Shippingaddressz> findAll();
	String create(Shippingaddressz pojo);
	String delete(int id);
	void create(ShippingAddressModel ship);
	
	Shippingaddressz findShippingAddressByOrderID(int id);
}