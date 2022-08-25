package com.coeding.springmvc.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.coeding.springmvc.dto.OrderItemDTO;
import com.coeding.springmvc.entity.Order;
import com.coeding.springmvc.entity.Product;

/**
 * 
 * @author Quan
 *
 */

@Repository
public class OrderDao {
	private static final Logger logger = LoggerFactory.getLogger(OrderDao.class);
	
	@Autowired
	private static SqlSessionFactory sessionFac;
	

	@Autowired
	public void setSessionFac(SqlSessionFactory sessionFac) {
		System.out.println(sessionFac);
		this.sessionFac = sessionFac;
	}
	
	
	
	public Order findById(int id) {
		SqlSession session = sessionFac.openSession();
		Order order = session.selectOne("orderz.selectOne");
		session.close();
		return order;
	}
	
	public List<Order> findAll() {
		SqlSession session = sessionFac.openSession();
		List<Order> orders = session.selectList("orderz.selectList");
		session.close();
		return orders;
	}
	
	

}
