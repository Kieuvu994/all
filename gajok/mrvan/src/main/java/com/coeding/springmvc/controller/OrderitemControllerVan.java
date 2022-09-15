package com.coeding.springmvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coeding.springmvc.dto.OrderitemDTO;
import com.coeding.springmvc.service.OrderitemService;

@Controller
@RequestMapping("/admin/orderitem")
public class OrderitemControllerVan {
	private static final Logger logger = LoggerFactory.getLogger(OrderitemControllerVan.class);
	@Autowired
	private OrderitemService orderitemSer;
	
	@GetMapping("/list")
	public String orderitemlist(Model model) {
		List<OrderitemDTO> list = orderitemSer.listOrderitem();
		model.addAttribute("orderitem", list);
		return "orderitem-listorderitem";

}

}
