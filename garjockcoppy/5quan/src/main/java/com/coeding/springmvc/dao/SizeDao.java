package com.coeding.springmvc.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeding.springmvc.entity.Size;


/**
 * 
 * @author Quan
 *
 */

@Repository
public class SizeDao {
	
	private static final Logger logger = LoggerFactory.getLogger(SizeDao.class);
	
	@Autowired
	private static SqlSessionFactory sessionFac;
	

	@Autowired
	public void setSessionFac(SqlSessionFactory sessionFac) {
		System.out.println(sessionFac);
		this.sessionFac = sessionFac;
	}
	
	
	
	public Size findById(int id) {
		SqlSession session = sessionFac.openSession();
		Size size = session.selectOne("mapper.size.selectById");
		session.close();
		return size;
	}
	
	public List<Size> findAll(){
		SqlSession session = sessionFac.openSession();
		List<Size> sizes = session.selectList("mapper.size.selectAll");
		session.close();
		return sizes;
	}
}
