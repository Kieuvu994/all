package com.coeding.springmvc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeding.springmvc.entity.Review;
import com.coeding.springmvc.entity.Size;

@Repository
public class ReviewDao {
	@Autowired
	private SqlSessionFactory sessionFac;

	@Autowired
	public void setSessionFac(SqlSessionFactory sessionFac) {
		System.out.println(sessionFac);
		this.sessionFac = sessionFac;
	}


	public List<Review> getReviewById(int id) {
		// TODO Auto-generated method stub
		SqlSession session = sessionFac.openSession();
		List<Review>  list = session.selectList("mapper.review.findById",id);
		session.close();
		return list;
		
	}
	
//	public Product getProductById(Integer id) {
//		SqlSession session = sessionFac.openSession();
//		Product listOne = session.selectOne("mapper.product.findById",id);
//		session.close();
//		return listOne;
//	}
//	public Product findById(int id) {
//		// TODO Auto-generated method stub
//		SqlSession session = sessionFac.openSession();
//		Product product = session.selectOne("mapper.product.findById",id);
//		session.close();
//		return product;
//		
//	}

	
}
