package com.coeding.springmvc.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coeding.springmvc.dto.ShippingaddressDTO;
import com.coeding.springmvc.entity.Shippingaddressz;
import com.coeding.springmvc.repository.ShippingaddressRepository;
import com.coeding.springmvc.service.ShippingaddressService;

@Service
public class ShippingaddressServiceImp implements ShippingaddressService {
	
	@Autowired
	private ShippingaddressRepository shippingaddressRepo;
	
	@Override
	public List<ShippingaddressDTO> listShippingaddress() {
		// TODO Auto-generated method stub
		List<Shippingaddressz> list = shippingaddressRepo.listShippingaddress();
		List<ShippingaddressDTO> lists = new ArrayList<ShippingaddressDTO>();
		if(lists != null) {
			for(Shippingaddressz lis : list) {
				ShippingaddressDTO shippingaddress = new ShippingaddressDTO(lis.getId(), lis.getAddress(), lis.getCity(), lis.getCountry(), lis.getPostalCode(), lis.getShippingPrice(), lis.getOrderz()
			);
				lists.add(shippingaddress);
			}
		}
		return lists;
	}

	@Override
	public int createShippingaddress(ShippingaddressDTO dto) {
		// TODO Auto-generated method stub
		Shippingaddressz shippingaddress = new Shippingaddressz(dto.getAddress(), dto.getCity(), dto.getCountry(), dto.getPostalCode(), dto.getShippingPrice(), dto.getOrderz()
				);
		shippingaddressRepo.createShippingaddress(shippingaddress);
		return 1;
	}



}
