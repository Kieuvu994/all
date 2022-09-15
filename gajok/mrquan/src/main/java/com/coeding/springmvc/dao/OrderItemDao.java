package com.coeding.springmvc.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeding.springmvc.dto.OrderItemDTO;
import com.coeding.springmvc.entity.Orderitem;

/**
 * 
 * @author Quan
 *
 */

@Repository
public class OrderItemDao {
	private static final Logger logger = LoggerFactory.getLogger(OrderItemDao.class);
	
	@Autowired
	private SqlSessionFactory sessionFac;

	@Autowired
	public void setSessionFac(SqlSessionFactory sessionFac) {
		System.out.println(sessionFac);
		this.sessionFac = sessionFac;
	}
	
	
	
	public OrderItemDTO getOrder() {
		SqlSession session = sessionFac.openSession();
		OrderItemDTO orderDetail = (OrderItemDTO) session.selectList("orderz.showOrderDetail");
		session.close();
		return orderDetail;
	}
	
}
