package com.coeding.springmvc.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeding.springmvc.entity.Category;

/**
 * 
 * @author Quan
 *
 */

@Repository
public class CategoryDao {
	private static final Logger logger = LoggerFactory.getLogger(CategoryDao.class);

	@Autowired
	private SqlSessionFactory sessionFac;

	@Autowired
	public void setSessionFac(SqlSessionFactory sessionFac) {
		this.sessionFac = sessionFac;
	}

	public List<Category> findAll() {
		SqlSession session = sessionFac.openSession();
		List<Category> list = session.selectList("mapper.category.selectAll");
		session.close();
		return list;
	}

	public List<Category> findAllById(int id) {
		SqlSession session = sessionFac.openSession();
		List<Category> list = session.selectList("mapper.category.selectById", id);
		session.close();
		return list;
	}
	

	public List<Category> findByName(String name) {
		SqlSession session = sessionFac.openSession();
		List<Category> list = session.selectList("mapper.category.selectByName", name);
		session.close();
		return list;
	}

	public int update(int id) {
		SqlSession session = sessionFac.openSession();
		session.update("mapper.category.update", id);
		session.close();
		return 1;
	}

	public void delete(int id) {
		SqlSession session = sessionFac.openSession();
		session.delete("mapper.category.deleteCategory", id);
		session.close();
	}
}
