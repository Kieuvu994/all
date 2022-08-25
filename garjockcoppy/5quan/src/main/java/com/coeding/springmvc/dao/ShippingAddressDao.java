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

import com.coeding.springmvc.entity.Shippingaddress;

/**
 * 
 * @author Quan
 *
 */

@Repository
public class ShippingAddressDao {

	private static final Logger logger = LoggerFactory.getLogger(ShippingAddressDao.class);

	@Autowired
	private static SqlSessionFactory sessionFac;
	

	@Autowired
	public void setSessionFac(SqlSessionFactory sessionFac) {
		System.out.println(sessionFac);
		this.sessionFac = sessionFac;
	}


	public Shippingaddress getAddress() {
		SqlSession session = sessionFac.openSession();
		Shippingaddress address = session.selectOne("address.showAddress");
		session.close();
		return address;
	}
	
	
	
}
