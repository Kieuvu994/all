package com.coeding.springmvc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeding.springmvc.entity.Categoryz;

@Repository
public class CategoryDao {

	@Autowired
	private SqlSessionFactory sessionFac;

	@Autowired
	public void setSessionFac(SqlSessionFactory sessionFac) {
		System.out.println(sessionFac);
		this.sessionFac = sessionFac;
	}

	public List<Categoryz> getAllCategory() {
		// TODO Auto-generated method stub
		SqlSession session = sessionFac.openSession();
		List<Categoryz> list = session.selectList("mapper.category.getAllCategory");
		session.close();
		return list;

	}

	
	

}
