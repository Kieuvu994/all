package com.coeding.springmvc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeding.springmvc.entity.Product;

/**
 * 
 * @author Quan
 *
 */

@Repository
public class ProductDao {

	@Autowired
	private SqlSessionFactory sessionFac;

	@Autowired
	public void setSessionFac(SqlSessionFactory sessionFac) {

		this.sessionFac = sessionFac;
	}

	public List<Product> getAllProduct() {

		SqlSession session = sessionFac.openSession();
		List<Product> list = session.selectList("mapper.product.listProduct");
		session.close();
		return list;

	}

	public Product findById(int id) {

		SqlSession session = sessionFac.openSession();
		Product product = session.selectOne("mapper.product.findById", id);
		session.close();
		return product;

	}
	
	
	public List<Product> findByCategory(int categoryId) {
		SqlSession session = sessionFac.openSession();
		List<Product> list = session.selectList("mapper.product.selectByCategory", categoryId);
		session.close();
		return list;
	}
	
	
	public List<Product> findByName(String name) {
		SqlSession session = sessionFac.openSession();
		List<Product> list = session.selectList("mapper.product.selectByName", name );
		session.close();
		return list;
	}
	
	public int addProduct(Product product) {
		SqlSession session = sessionFac.openSession();
		session.insert("mapper.product.addProduct", product);
		session.close();
		return 1;
	}
	
	public int updateCountInStock(int id) {
		SqlSession session = sessionFac.openSession();
		session.update("mapper.product.updateCountInStock", id);
		session.close();
		return 1;
	}
	
	public int updateProduct(int id ) {
		SqlSession session = sessionFac.openSession();
		session.update("mapper.product.updateProduct", id);
		session.close();
		return 1;
	}
	
	public void delete(int id) {
		SqlSession session = sessionFac.openSession();
		session.delete("mapper.product.deleteProduct", id);
		session.close();
	}
	
	public Product findRecent() {
		SqlSession session = sessionFac.openSession();
		Product product = (Product) session.selectOne("mapper.product.recentOne");
		session.close();
		return product;
	}
	

}