package com.coeding.springmvc.repository.impl;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coeding.springmvc.entity.Categoryz;
import com.coeding.springmvc.repository.CategoryRepository;

@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository {
	
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(CategoryRepositoryImpl.class);

	@Autowired
	private SqlSessionFactory sessionFactory;
	
	public void setSessionFactory(SqlSessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public Optional<Categoryz> findById(int id) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		Categoryz category = session.selectOne("mapper.category.findById", id);
		logger.info("Category ::"+category);
		return Optional.ofNullable(category);
	}

	@Override
	public List<Categoryz> findAll() {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		List<Categoryz> categoryList = session.selectList("mapper.category.findAll");
		for(Categoryz p : categoryList){
			logger.info("Category List::"+p);
		}
		return categoryList;
	}

	@Override
	public String create(Categoryz pojo) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		session.insert("mapper.category.create", pojo);
		session.commit();
		logger.info("Create category::");
		return "Create category";
	}

	@Override
	public String update(Categoryz pojo) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		session.update("mapper.category.update", pojo);
		session.commit();
		logger.info("update category::");
		return "update category";
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		session.delete("mapper.category.delete", id);
		session.commit();
		logger.info("delete category::");
		return "delete category";
	}

}
