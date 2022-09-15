package com.coeding.springmvc.repository.impl;

import java.util.Collection;
import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coeding.springmvc.entity.Orderitemz;
import com.coeding.springmvc.entity.Orderz;
import com.coeding.springmvc.entity.Productz;
import com.coeding.springmvc.entity.Userz;
import com.coeding.springmvc.global.GlobalDara;
import com.coeding.springmvc.model.OrderModel;
import com.coeding.springmvc.repository.OrderItemRepository;
import com.coeding.springmvc.repository.OrderRepository;
import com.coeding.springmvc.service.CartService;

@Repository
@Transactional
public class OrderRepositoryImpl implements OrderRepository {
	
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(OrderRepositoryImpl.class);

	@Autowired
	private SqlSessionFactory sessionFactory;
	
	@Autowired
	private OrderItemRepository orderitemRepository;

	@Override
	public Orderz findById(int id) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		Orderz order = session.selectOne("mapper.order.findById", id);
		logger.info("order ::"+order);
		return order;
	}

	@Override
	public List<Orderz> findAll() {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		List<Orderz> order = session.selectList("mapper.order.findAll");
		for(Orderz p : order){
			logger.info("order List::"+p);
		}
		return order;
	}

	@Override
	public String create(Orderz pojo) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		session.insert("mapper.order.create", pojo);
		session.commit();
		logger.info("Create order::");
		return "Create order";
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		session.delete("mapper.order.delete", id);
		session.commit();
		logger.info("order category::");
		return "order category";
	}

	
	//not used yet
	@Override
	public void createOrderDetail(Orderz o) {
		// TODO Auto-generated method stub
		this.create(o);
		Collection<Productz> items = GlobalDara.cart;
		items.forEach(p -> {
			Orderitemz detail = new Orderitemz();
			detail.setOrderz(o);
			detail.setProductz(p);
			detail.setImage(p.getImage());
			detail.setName(p.getName());
			detail.setQty(p.getQuantity());
			orderitemRepository.create(detail);
		});
	}

	@Override
	public List<Orderz> findByUser(Userz user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createModel(OrderModel model) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		session.insert("mapper.order.create", model);
		session.commit();
		logger.info("Create order::");
	}

	@Override
	public Orderz takeID() {
		// TODO Auto-generated method stub
		return null;
	}

}
