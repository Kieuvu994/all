package com.coeding.springmvc.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coeding.springmvc.dto.ProductDTO;
import com.coeding.springmvc.entity.Categoryz;
import com.coeding.springmvc.entity.Productz;
import com.coeding.springmvc.repository.ProductRepository;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(ProductRepositoryImpl.class);

	@Autowired
	private SqlSessionFactory sessionFactory;
	
	public void setSessionFactory(SqlSessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public Productz findById(int id) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		Productz product = session.selectOne("mapper.product.findById", id);
		logger.info("Category ::"+product);
		return product;
	}

	@Override
	public List<Productz> findAll() {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		List<Productz> productList = session.selectList("mapper.product.findAll");
		for(Productz p : productList){
			logger.info("Product List::"+p);
		}
		return productList;
	}

	@Override
	public String create(Productz pojo) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		session.insert("mapper.product.create", pojo);
		session.commit();
		logger.info("Create product::");
		return "Create product";
	}

	@Override
	public String update(Productz pojo) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		session.update("mapper.product.update", pojo);
		session.commit();
		logger.info("update product::");
		return "update product";
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		session.delete("mapper.product.delete", id);
		session.commit();
		logger.info("delete product::");
		return "delete product";
	}

	@Override
	public List<Productz> findAllProductByCategoryId(int id) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		List<Productz> productList = session.selectList("mapper.product.findAllProductByCategoryId", id);
		for(Productz p : productList){
			logger.info("Product List::"+p);
		}
		return productList;
	}

	@Override
	public List<Productz> findByKeywords(String keywords) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Productz> findItemByHot(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Productz> findByIdsInCookie(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
