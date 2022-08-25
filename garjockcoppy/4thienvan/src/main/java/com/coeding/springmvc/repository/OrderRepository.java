package com.coeding.springmvc.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.coeding.springmvc.dto.OrderDTO;
import com.coeding.springmvc.entity.Orderz;

@Repository
public class OrderRepository {
	private SqlSessionFactory sessionFac;
	
	@Autowired
	public void setSessionFac(SqlSessionFactory sessionFac) {
		System.out.println(sessionFac);
		this.sessionFac = sessionFac;
	}

	public List<Orderz> listOrder(){
		SqlSession session = sessionFac.openSession();
		List<Orderz> list = session.selectList("thienvan.order.listOrder");
		session.close();
		return list;
	}

}
