package com.coeding.springmvc.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeding.springmvc.entity.Orderitemz;

@Repository
public class OrderitemRepository {
	private SqlSessionFactory sessionFac;
	
	@Autowired
	public void setSessionFac(SqlSessionFactory sessionFac) {
		System.out.println(sessionFac);
		this.sessionFac = sessionFac;
	}
	
	
	public List<Orderitemz> listOrderitem(){
		SqlSession session = sessionFac.openSession();
		List<Orderitemz> list = session.selectList("thienvan.orderitem.listOrderitem");
		session.close();
		return list;
	}

}
