package com.coeding.springmvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coeding.springmvc.dto.ShippingaddressDTO;
import com.coeding.springmvc.service.ShippingaddressService;

@Controller
@RequestMapping("/admin/shippingaddress")
public class ShippingaddressControllerVan {
	private static final Logger logger = LoggerFactory.getLogger(ShippingaddressControllerVan.class);
	@Autowired
	private ShippingaddressService shippingSer;
	
	@GetMapping("/list")
	public String shippingaddresslist(Model model) {
		List<ShippingaddressDTO> list = shippingSer.listShippingaddress();
		model.addAttribute("shippingaddress", list);
		return "shipping-listshipping";

	}
	
	@GetMapping("/add")
	public String addShipingaddress (Model model) {
		System.out.println("is add");
		model.addAttribute("shippingaddressDTO", new ShippingaddressDTO());
		return "shipping-addShipping";	
	}
	
	@PostMapping("/add")
	public String postAddShipping(ShippingaddressDTO dto) {
		int in = shippingSer.createShippingaddress(dto);
		return "redirect:/admin/shippingaddress/list";
	}
	
}
