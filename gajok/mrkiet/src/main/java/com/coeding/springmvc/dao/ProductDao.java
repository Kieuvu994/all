package com.coeding.springmvc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeding.springmvc.entity.Productz;

@Repository
public class ProductDao {
	@Autowired
	private SqlSessionFactory sessionFac;

	@Autowired
	public void setSessionFac(SqlSessionFactory sessionFac) {
		System.out.println(sessionFac);
		this.sessionFac = sessionFac;
	}


	public List<Productz> getAllProduct() {
		// TODO Auto-generated method stub
		SqlSession session = sessionFac.openSession();
		List<Productz>  list = session.selectList("mapper.product.listProduct");
		session.close();
		return list;
		
	}
//	public Product findById(int id) {
//		// TODO Auto-generated method stub
//		SqlSession session = sessionFac.openSession();
//		Product product = session.selectOne("mapper.product.findById",id);
//		session.close();
//		return product;
//		
//	}

	
}