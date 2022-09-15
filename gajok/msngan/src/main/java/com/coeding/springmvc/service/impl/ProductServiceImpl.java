package com.coeding.springmvc.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coeding.springmvc.dao.ProductDao;

import com.coeding.springmvc.entity.Product;
import com.coeding.springmvc.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{


    @Autowired
	private ProductDao dao;
	

	@Override
	public List<Product> listProduct() {
//		SqlSession session = sessionFac.openSession();
//		List<Product>  list = session.selectList("mapper.product.listProduct");
//		session.close();
		return dao.getAllProduct();
	}

	@Override
	public int deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		Product product = (Product) dao.getProductById(id);
		return product ;
	}

	@Override
	public List<Product> listLastProduct() {
		// TODO Auto-generated method stub
		return dao.getLastProduct();
	}

	@Override
	public List<Product> listTopRatedProduct() {
		// TODO Auto-generated method stub
		return dao.getTopRatedProduct();
	}

	@Override
	public List<Product> listTopReviewProduct() {
		// TODO Auto-generated method stub
		return dao.getTopReviewProduct();
	}

	@Override
	public List<Product> listProductByCategory(int id) {
		// TODO Auto-generated method stub
		return dao.getProductByCategory(id);
	}

	@Override
	public List<Product> listSearchProduct(String txt) {
		// TODO Auto-generated method stub
		return dao.getSearchProduct(txt);
	}

	
	@Override
	public List<Product> getProductPaging(int currentPage, int itemsPerPage) {
		int offset = (currentPage - 1) * itemsPerPage;
		return dao.getProductPaging(offset, itemsPerPage);
	}

	@Override
	public int countProduct() {
		// TODO Auto-generated method stub
		return dao.countProduct();
	}

	@Override
	public int[] countPage() {
		// TODO Auto-generated method stub
		int pageNumber = dao.countProduct()/6;
		if(dao.countProduct()%6 != 0) {
			pageNumber+=1;
		}
		
		int[] page = new int[pageNumber];
		
		for(int i = 0;i<pageNumber;i++) {
			page[i]=i+1;
		}
		
		return page;
	}

	

}
