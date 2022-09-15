package com.coeding.springmvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coeding.springmvc.dto.OrderDTO;
import com.coeding.springmvc.service.OrderService;

@Controller
@RequestMapping("/admin/order")
public class OrderControllerVan {
	private static final Logger logger = LoggerFactory.getLogger(OrderControllerVan.class);
	@Autowired
	private OrderService orderSer;

	@GetMapping("/list")
	public String orderlist(Model model) {
		List<OrderDTO> list = orderSer.listOrder();
		model.addAttribute("order", list);
		return "order-listorder";

	}

}