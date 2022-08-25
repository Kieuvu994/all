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

import com.coeding.springmvc.entity.Topping;


/**
 * 
 * @author Quan
 *
 */

@Repository
public class ToppingDao {
	
	private static final Logger logger = LoggerFactory.getLogger(ToppingDao.class);
	
	@Autowired
	private static SqlSessionFactory sessionFac;
	

	@Autowired
	public void setSessionFac(SqlSessionFactory sessionFac) {
		System.out.println(sessionFac);
		this.sessionFac = sessionFac;
	}
	
	
	
	public Topping findById(int id) {
		SqlSession session = sessionFac.openSession();
		Topping topping = session.selectOne("mapper.topping.selectById");
		session.close();
		return topping;
	}
	
	public List<Topping> findAll(){
		SqlSession session = sessionFac.openSession();
		List<Topping> toppings = session.selectList("mapper.topping.selectAll");
		session.close();
		return toppings;
	}
}