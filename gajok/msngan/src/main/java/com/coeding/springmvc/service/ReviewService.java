package com.coeding.springmvc.service;

import java.util.List;

import com.coeding.springmvc.entity.Review;

public interface ReviewService {
	List<Review> getReviewById(int id);
}
