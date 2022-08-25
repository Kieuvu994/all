package com.coeding.springmvc.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeding.springmvc.entity.Product;

@Repository
public class ProductDao {
	@Autowired
	private SqlSessionFactory sessionFac;

	@Autowired
	public void setSessionFac(SqlSessionFactory sessionFac) {
		System.out.println(sessionFac);
		this.sessionFac = sessionFac;
	}


	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		SqlSession session = sessionFac.openSession();
		List<Product>  list = session.selectList("mapper.product.listProduct");
		session.close();
		return list;
		
	}
	
	public Product getProductById(Integer id) {
		SqlSession session = sessionFac.openSession();
		Product listOne = session.selectOne("mapper.product.findById",id);
		session.close();
		return listOne;
	}
	
	public List<Product> getLastProduct() {
		// TODO Auto-generated method stub
		SqlSession session = sessionFac.openSession();
		List<Product>  list = session.selectList("mapper.product.findLastProduct");
		session.close();
		return list;
		
	}
	
	public List<Product> getTopRatedProduct() {
		// TODO Auto-generated method stub
		SqlSession session = sessionFac.openSession();
		List<Product>  list = session.selectList("mapper.product.findTopRatedProduct");
		session.close();
		return list;
		
	}
	
	public List<Product> getTopReviewProduct() {
		// TODO Auto-generated method stub
		SqlSession session = sessionFac.openSession();
		List<Product>  list = session.selectList("mapper.product.findTopReviewProduct");
		session.close();
		return list;
		
	}

	public List<Product> getProductByCategory(Integer id) {
		SqlSession session = sessionFac.openSession();
		List<Product> list = session.selectList("mapper.product.findByCatogory",id);
		session.close();
		return list;
	}
	
	public List<Product> getSearchProduct(String txt) {
		SqlSession session = sessionFac.openSession();
		List<Product> list = session.selectList("mapper.product.findProduct",txt);
		session.close();
		return list;
	}
	
	public List<Product> getProductPaging(int offset, int itemsPerPage) {
		// TODO Auto-generated method stub
		
		SqlSession session = sessionFac.openSession();
		List<Product>  list = session.selectList("mapper.product.listProductPaging", new RowBounds(offset, itemsPerPage));
		session.close();
		return list;
		
	}
	
	public int countProduct() {
		// TODO Auto-generated method stub
		
		SqlSession session = sessionFac.openSession();
		int  count = session.selectOne("mapper.product.countProduct");
		session.close();
		return count;
		
	}
}