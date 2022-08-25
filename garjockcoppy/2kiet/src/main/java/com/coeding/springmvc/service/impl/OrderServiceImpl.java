package com.coeding.springmvc.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coeding.springmvc.entity.Orderitemz;
import com.coeding.springmvc.entity.Orderz;
import com.coeding.springmvc.entity.Productz;
import com.coeding.springmvc.global.GlobalDara;
import com.coeding.springmvc.model.OrderModel;
import com.coeding.springmvc.repository.OrderItemRepository;
import com.coeding.springmvc.repository.OrderRepository;
import com.coeding.springmvc.repository.UserRepository;
import com.coeding.springmvc.service.OrderService;
import com.coeding.springmvc.service.UserService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Orderz findById(int id) {
		// TODO Auto-generated method stub
		return this.orderRepository.findById(id);
	}

	@Override
	public List<Orderz> findAll() {
		// TODO Auto-generated method stub
		return this.orderRepository.findAll();
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		return this.orderRepository.delete(id);
	}

	@Override
	public Orderz createOrder(Orderz o) {
		// TODO Auto-generated method stub
		
		BigDecimal total=new BigDecimal(0.00);
		for (int i = 0; i < GlobalDara.cart.size(); i++) {
			total = total.add( GlobalDara.cart.get(i).getPrice().multiply(BigDecimal.valueOf( GlobalDara.cart.get(i).getQuantity())));
		}
		BigDecimal taxPrice = total.multiply(new BigDecimal(0.1)).setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal shippingPrice = new BigDecimal(35.00).setScale(2);
		Orderz order = new Orderz();
		System.out.println("createOrder: OrderServiceImpl: -->>" + o.getId());
		
		order.setId(o.getId());
		order.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		order.setDeliveredAt(new Timestamp(System.currentTimeMillis()));
		order.setIsDelivered(Byte.valueOf("1"));
		order.setIsPaid(Byte.valueOf("1"));
		order.setPaidAt(new Timestamp(System.currentTimeMillis()));
		order.setPaymentMethod("PayPal");//checkout getPay..
		order.setShippingPrice(shippingPrice);
		order.setTaxPrice(taxPrice);
		order.setTotalPrice(total.add(shippingPrice).add(taxPrice));
		order.setUserz(userRepository.findById(3));
		this.orderRepository.create(order);
		return order;
	}

	@Override
	public void addOrderAndOrderDetail(Orderz o) {
		// TODO Auto-generated method stub
		orderRepository.create(o);
		Collection<Productz> items = GlobalDara.cart;
		items.forEach(p -> {
			Orderitemz detail = new Orderitemz();
			detail.setOrderz(o);
			detail.setProductz(p);
			detail.setImage(p.getImage());
			detail.setName(p.getName());
			detail.setPrice(p.getPrice());
			detail.setQty(p.getQuantity());
			orderItemRepository.create(detail);
		});
		
	}

	@Override
	public List<Orderz> getAllOrderByUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orderz findById(Integer id) {
		// TODO Auto-generated method stub
		return orderRepository.findById(id);
	}

	@Override
	public Map<Integer, Productz> getPurchasedItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createModel(OrderModel model) {
		// TODO Auto-generated method stub
		this.orderRepository.createModel(model);
	}

	@Override
	public Orderz takeID() {
		// TODO Auto-generated method stub
		return this.orderRepository.takeID();
	}

}