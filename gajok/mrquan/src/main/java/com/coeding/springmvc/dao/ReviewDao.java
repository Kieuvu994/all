
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

import com.coeding.springmvc.entity.Review;


/**
 * 
 * @author Quan
 *
 */

@Repository
public class ReviewDao {
	private static final Logger logger = LoggerFactory.getLogger(ReviewDao.class);
	
	@Autowired
	private static SqlSessionFactory sessionFac;
	

	@Autowired
	public void setSessionFac(SqlSessionFactory sessionFac) {
		System.out.println(sessionFac);
		this.sessionFac = sessionFac;
	}
	

	
	
	public Review findOneById(int id) {
		SqlSession session = sessionFac.openSession();
		Review review = session.selectOne("reviewz.selectOneById");
		session.close();
		return review;
	}
	
	
	public void delete(int id) {
		SqlSession session = sessionFac.openSession();
		session.delete("reviewz.deleteProduct");
		session.close();
	}
	
	public int updateReview() {
		SqlSession session = sessionFac.openSession();
		session.update("reviewz.updateReview");
		session.close();
		return 1;
	}
	
}
