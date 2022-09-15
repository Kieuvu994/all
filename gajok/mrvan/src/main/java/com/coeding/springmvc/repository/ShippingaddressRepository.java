package com.coeding.springmvc.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.header.writers.frameoptions.StaticAllowFromStrategy;
import org.springframework.stereotype.Repository;

import com.coeding.springmvc.entity.Shippingaddressz;

@Repository
public class ShippingaddressRepository {
	private SqlSessionFactory sessionFac;
	
	@Autowired
	public void setSessionFac(SqlSessionFactory sessionFac) {
		System.out.println(sessionFac);
		this.sessionFac = sessionFac;
	}
//	@Autowired
//	private static final Logger logger = LoggerFactory.getLogger(ShippingaddressRepository.class);

	
	public List<Shippingaddressz> listShippingaddress(){
		SqlSession session = sessionFac.openSession();
		List<Shippingaddressz> list = session.selectList("thienvan.shippingaddress.listShippingaddress");
		session.close();
		return list;
	}
	
	public int createShippingaddress(Shippingaddressz shipping) {
		SqlSession session = sessionFac.openSession();
		int in = session.insert("thienvan.shippingaddress.addShippingaddress", shipping);
		session.commit();
		session.close();
		return in;
	}
	
}
