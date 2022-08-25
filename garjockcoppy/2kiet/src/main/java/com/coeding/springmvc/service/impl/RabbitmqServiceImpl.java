package com.coeding.springmvc.service.impl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coeding.springmvc.entity.Orderz;
import com.coeding.springmvc.entity.Productz;
import com.coeding.springmvc.entity.Shippingaddressz;
import com.coeding.springmvc.global.GlobalDara;
import com.coeding.springmvc.model.OrderItemModel;
import com.coeding.springmvc.model.OrderModel;
import com.coeding.springmvc.model.ShippingAddressModel;
import com.coeding.springmvc.service.OrderItemService;
import com.coeding.springmvc.service.OrderService;
import com.coeding.springmvc.service.RabbitmqService;
import com.coeding.springmvc.service.ShippingaddressService;

@Service
public class RabbitmqServiceImpl implements RabbitmqService {
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(RabbitmqServiceImpl.class);
	@Autowired
	private OrderItemService orderItemService;
	@Autowired
	private ShippingaddressService shippingAddressService;

	@Override
	public void converToSendRabbit(Orderz o, Shippingaddressz shipping) {
		// TODO Auto-generated method stub
		OrderModel model = new OrderModel();
		
		logger.info("Create OrderModel:: "+model);
		System.out.println("order: " + "ID {" + o.getId() +"}, "+ o.getCreatedAt() + ", "+ o.getDeliveredAt()
		 + ", "+ o.getIsDelivered() + ", "+ o.getIsPaid() + ", "+ o.getPaidAt() + ", "+ o.getPaymentMethod()
		 + ",ShippingAddress can null:{ "+ o.getShippingaddresszs() + "}, "+ o.getTaxPrice() + ", "+ o.getTotalPrice()+ ", "+ o.getShippingPrice());
		
		ShippingAddressModel ship = new ShippingAddressModel();
		ship.setAddress(shipping.getAddress());
		ship.setCity(shipping.getCity());
		ship.setCountry(shipping.getCountry());
		ship.setPostalCode(shipping.getPostalCode());
		ship.setShippingPrice(o.getShippingPrice());
		ship.setOrderID(o.getId());
		shippingAddressService.create(ship);
		logger.info("Create ShippingAddressModel:: "+ship);
		
		Collection<Productz> items = GlobalDara.cart;
		List<OrderItemModel> s = new ArrayList<OrderItemModel>();
		for (Productz p : items) {
			OrderItemModel detail = new OrderItemModel();
			detail.setProductID(p.getId());
			detail.setOrderID(o.getId());
			detail.setImage(p.getImage());
			detail.setName(p.getName());
			detail.setPrice(p.getPrice());
			detail.setQty(p.getQuantity());
			detail.setSizeID(1);
			detail.setToppingID(1);
			s.add(detail);
			orderItemService.create(detail);
			logger.info("Create OrderItemModel:: "+detail);
			System.out.println("ORDERITEMS: "+ detail.getId() + ", "+ detail.getProductID()+ ", "+ detail.getOrderID()+ ", "+ detail.getImage()
			+ ", "+ detail.getName()+ ", "+ detail.getPrice()+ ", "+ detail.getQty()+", size:"+detail.getSizeID()+", topping:"+detail.getToppingID());
		}
		model.setCreatedAt(o.getCreatedAt());
		model.setDeliveredAt(o.getDeliveredAt());
		model.setIsDelivered(o.getIsDelivered());
		model.setIsPaid(o.getIsPaid());
		model.setPaidAt(o.getPaidAt());
		model.setPaymentMethod(o.getPaymentMethod());
		model.setShippingPrice(o.getShippingPrice());
		model.setTaxPrice(o.getTaxPrice());
		model.setTotalPrice(o.getTotalPrice());
		model.getOrderitem().addAll(s);
		logger.info("Create OrderModel:: "+model);
		
	}
}