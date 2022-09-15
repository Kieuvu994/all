package com.coeding.springmvc.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coeding.springmvc.entity.Productz;
import com.coeding.springmvc.repository.ProductRepository;
import com.coeding.springmvc.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private ProductRepository productRepository;
	
	Map<Integer, Productz> map = new HashMap<Integer, Productz>();

	@Override
	public void addCart(Integer id) {
		// TODO Auto-generated method stub
		Productz p = map.get(id);
		if (p != null) { 
			p.setQuantity(p.getQuantity() + 1);
		} else { 
			p = productRepository.findById(id);
			p.setQuantity(1);
			map.put(id, p);
		}
	}

	@Override
	public void removeCart(Integer id) {
		// TODO Auto-generated method stub
		map.remove(id);
	}

	@Override
	public void updateCart(Integer id, int qty) {
		// TODO Auto-generated method stub
		Productz product = map.get(id);
		product.setQuantity(qty);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		map.clear();
	}

	@Override
	public int getCountCart() {
		// TODO Auto-generated method stub
		Collection<Productz> product = this.getItemsCart();
		int count = 0;
		for (Productz productz : product) {
			count += productz.getQuantity();
		}
		return count;
	}

	@Override
	public double getAmountCart() {
		// TODO Auto-generated method stub
		Collection<Productz> product = this.getItemsCart();
		double amount = 0;
		for (Productz p : product) {
			amount += (p.getQuantity() * (p.getPrice().doubleValue() - (p.getPrice().doubleValue() * p.getDiscount())));
		}
		return amount;
	}

	@Override
	public Collection<Productz> getItemsCart() {
		// TODO Auto-generated method stub
		return map.values();
	}

}
