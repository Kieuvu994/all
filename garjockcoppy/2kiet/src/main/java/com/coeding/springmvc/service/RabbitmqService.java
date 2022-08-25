package com.coeding.springmvc.service;

import com.coeding.springmvc.entity.Orderz;
import com.coeding.springmvc.entity.Shippingaddressz;

public interface RabbitmqService {
	void converToSendRabbit(Orderz o, Shippingaddressz shipping);
}
