package com.coeding.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coeding.springmvc.dao.ReviewDao;
import com.coeding.springmvc.entity.Review;
import com.coeding.springmvc.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDao dao;
	
	@Override
	public List<Review> getReviewById(int id) {
		// TODO Auto-generated method stub
		return dao.getReviewById(id);
	}

}
