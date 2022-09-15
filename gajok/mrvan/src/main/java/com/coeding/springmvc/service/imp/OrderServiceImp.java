package com.coeding.springmvc.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coeding.springmvc.dto.OrderDTO;
import com.coeding.springmvc.entity.Orderz;
import com.coeding.springmvc.repository.OrderRepository;
import com.coeding.springmvc.service.OrderService;

@Service
public class OrderServiceImp implements OrderService {

	@Autowired
	private OrderRepository orderRepo;

	@Override
	public List<OrderDTO> listOrder() {
		// TODO Auto-generated method stub

		List<Orderz> list = orderRepo.listOrder();
		List<OrderDTO> lists = new ArrayList<OrderDTO>();
		if (lists != null) {
			for (Orderz lis : list) {
				OrderDTO order = new OrderDTO(lis.getId(), lis.getUserz(), lis.getCreatedAt(), lis.getDeliveredAt(),
						lis.getIsDelivered(), lis.getIsPaid(), lis.getPaidAt(), lis.getPaymentMethod(),
						lis.getShippingPrice(), lis.getTaxPrice(), lis.getTotalPrice());

				lists.add(order);
			}
		}
		return lists;
	}

}
