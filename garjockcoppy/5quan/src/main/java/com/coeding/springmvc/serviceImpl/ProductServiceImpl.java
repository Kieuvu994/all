package com.coeding.springmvc.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coeding.springmvc.dao.ProductDao;

import com.coeding.springmvc.entity.Product;
import com.coeding.springmvc.service.ProductService;

/**
 * 
 * @author Quan
 *
 */

@Service
public class ProductServiceImpl implements ProductService{


    @Autowired
	private ProductDao dao;
	

	@Override
	public Product getProductById(Integer id) {

		return dao.findById(id);
	}

	@Override
	public List<Product> listProduct() {
//		SqlSession session = sessionFac.openSession();
//		List<Product>  list = session.selectList("mapper.product.listProduct");
//		session.close();
		return dao.getAllProduct();
	}

	

	@Override
	public List<Product> findByCategory(int categoryId) {

		return dao.findByCategory(categoryId);
	}

	@Override
	public List<Product> findByName(String name) {
			
		return dao.findByName(name);
	}

	@Override
	public int addProductz(Product productz) {
		
		return 1;
	}

	@Override
	public int updateCountInStock(int id) {

		return 1;
	}
	
	@Override
	public int updateProduct(int id) {
		
		return 1;
	}

	@Override
	public void delete(int id) {
		
	}

	@Override
	public Product findRecent() {

		return dao.findRecent();
	}

	

}
