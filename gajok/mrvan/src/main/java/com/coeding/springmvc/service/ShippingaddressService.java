package com.coeding.springmvc.service;

import java.util.List;

import com.coeding.springmvc.dto.ShippingaddressDTO;

public interface ShippingaddressService {
	
	List<ShippingaddressDTO> listShippingaddress();
	
	int createShippingaddress(ShippingaddressDTO dto);
	
	

}
