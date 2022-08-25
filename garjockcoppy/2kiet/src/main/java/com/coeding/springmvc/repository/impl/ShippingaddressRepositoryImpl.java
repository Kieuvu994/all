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
import com.coeding.springmvc.entity.Shippingaddressz;
import com.coeding.springmvc.model.ShippingAddressModel;
import com.coeding.springmvc.repository.ShippingaddressRepository;

@Repository
@Transactional
public class ShippingaddressRepositoryImpl implements ShippingaddressRepository {

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(ShippingaddressRepositoryImpl.class);

	@Autowired
	private SqlSessionFactory sessionFactory;
	
	@Override
	public Shippingaddressz findById(int id) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		Shippingaddressz shipping = session.selectOne("mapper.shipping.findById", id);
		logger.info("Shipping ::"+shipping);
		return shipping;
	}

	@Override
	public List<Shippingaddressz> findAll() {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		List<Shippingaddressz> shipping = session.selectList("mapper.shipping.findAll");
		for(Shippingaddressz p : shipping){
			logger.info("shipping List::"+p);
		}
		return shipping;
	}

	@Override
	public String create(Shippingaddressz pojo) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		session.insert("mapper.shipping.create", pojo);
		session.commit();
		logger.info("Create shipping::");
		return "Create shipping";
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		session.delete("mapper.shipping.delete", id);
		session.commit();
		logger.info("delete shipping::");
		return "delete shipping";
	}

	@Override
	public void create(ShippingAddressModel ship) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		session.insert("mapper.shipping.create", ship);
		session.commit();
		logger.info("Create shipping::");
	}

	@Override
	public Shippingaddressz findShippingAddressByOrderID(int id) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		Shippingaddressz Shippingaddressz = session.selectOne("mapper.shipping.findShippingAddressByOrderID", id);
		logger.info("Checkout done!! Shippingaddressz Repo::"+Shippingaddressz);
		return Shippingaddressz;
	}

}