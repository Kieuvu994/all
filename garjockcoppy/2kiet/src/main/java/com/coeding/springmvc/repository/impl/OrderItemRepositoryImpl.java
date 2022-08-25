package com.coeding.springmvc.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coeding.springmvc.entity.Orderitemz;
import com.coeding.springmvc.model.OrderItemModel;
import com.coeding.springmvc.repository.OrderItemRepository;

@Repository
@Transactional
public class OrderItemRepositoryImpl implements OrderItemRepository {
	
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(OrderItemRepositoryImpl.class);

	@Autowired
	private SqlSessionFactory sessionFactory;

	@Override
	public Orderitemz findById(int id) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		Orderitemz orderitem = session.selectOne("mapper.orderitem.findById", id);
		logger.info("Orderitemz ::"+orderitem);
		return orderitem;
	}

	@Override
	public List<Orderitemz> findAll() {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		List<Orderitemz> Orderitemz = session.selectList("mapper.orderitem.findAll");
		for(Orderitemz p : Orderitemz){
			logger.info("orderitem List::"+p);
		}
		return Orderitemz;
	}

	@Override
	public String create(Orderitemz pojo) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		session.insert("mapper.orderitem.create", pojo);
		session.commit();
		logger.info("Create orderitem::");
		return "Create orderitem";
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		session.delete("mapper.orderitem.delete", id);
		session.commit();
		logger.info("delete orderitem::");
		return "delete orderitem";
	}

	@Override
	public void create(OrderItemModel s) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		session.insert("mapper.orderitem.create", s);
		session.commit();
		logger.info("Create orderitem::");
	}

	@Override
	public List<Orderitemz> findOrderItemByOrderID(int id) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		List<Orderitemz> Orderitemz = session.selectList("mapper.orderitem.findOrderItemByOrderID", id);
		for(Orderitemz p : Orderitemz){
			logger.info("Checkout done!! orderitem ::"+p);
		}
		return Orderitemz;
	}

}