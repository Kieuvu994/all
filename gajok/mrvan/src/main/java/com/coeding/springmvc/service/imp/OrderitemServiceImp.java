package com.coeding.springmvc.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coeding.springmvc.dto.OrderitemDTO;
import com.coeding.springmvc.entity.Orderitemz;
import com.coeding.springmvc.repository.OrderitemRepository;
import com.coeding.springmvc.service.OrderitemService;

@Service
public class OrderitemServiceImp implements OrderitemService {

	@Autowired
	private OrderitemRepository orderitemRepo;

	@Override
	public List<OrderitemDTO> listOrderitem() {
		// TODO Auto-generated method stub
		List<Orderitemz> list = orderitemRepo.listOrderitem();
		List<OrderitemDTO> lists = new ArrayList<OrderitemDTO>();
		if(lists != null) {
			for (Orderitemz lis : list) {
				OrderitemDTO orderitem = new OrderitemDTO(lis.getId(), lis.getName(), lis.getOrderz(), lis.getProductz(), lis.getSizez(),
						lis.getTopping(), lis.getPrice(), lis.getQty(), lis.getImage()
						);
				
			lists.add(orderitem);
			}
		}
		return lists;
	}



}
