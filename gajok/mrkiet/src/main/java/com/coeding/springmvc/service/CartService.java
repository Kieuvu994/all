package com.coeding.springmvc.service;

import java.util.Collection;

import com.coeding.springmvc.entity.Productz;

public interface CartService {

	void addCart(Integer id);
	void removeCart(Integer id);
	void updateCart(Integer id, int qty);
	void clear();
	int getCountCart();
	double getAmountCart();
	Collection<Productz> getItemsCart();
}
