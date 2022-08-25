package com.coeding.springmvc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coeding.springmvc.entity.Productz;
import com.coeding.springmvc.repository.ProductRepository;
import com.coeding.springmvc.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	// Có thể inject bằng cách khác, mình viết như thế này cho gọn
	
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Optional<Productz> findById(int id) {
		// TODO Auto-generated method stub
		return Optional.of(this.productRepository.findById(id));
	}

	@Override
	public List<Productz> findAll() {
		// TODO Auto-generated method stub
		return this.productRepository.findAll();
	}

	@Override
	public String create(Productz pojo) {
		// TODO Auto-generated method stub
		return this.productRepository.create(pojo);
	}

	@Override
	public String update(Productz pojo) {
		// TODO Auto-generated method stub
		return this.productRepository.update(pojo);
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		return this.productRepository.delete(id);
	}

	@Override
	public List<Productz> findAllProductByCategoryId(int id) {
		// TODO Auto-generated method stub
		return this.productRepository.findAllProductByCategoryId(id);
	}
	
//    @Autowired
//	private ProductDao dao;
	
//	private ProductDao productDao;
//	@Override
//	public Product getProductById(int id) {
//		// TODO Auto-generated method stub
//		return dao.findById(id);
//	}

//	@Override
//	public List<Product> listProduct() {
//		SqlSession session = sessionFac.openSession();
//		List<Product>  list = session.selectList("mapper.product.listProduct");
//		session.close();
//		return list;
//	}
//
//	@Override
//	public int deleteUser(Integer id) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public Product getProductById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
