package com.coeding.springmvc.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.coeding.springmvc.entity.Size;
import com.coeding.springmvc.dao.SizeDao;
import com.coeding.springmvc.service.SizeService;

/**
 * 
 * @author Quan
 *
 */

@Service
public class SizeServiceImpl implements SizeService {

	@Autowired
	SizeDao sizeDao;

	@Override
	public Size findById(int id) {

		return sizeDao.findById(id);
	}

	@Override
	public List<Size> findAll() {
		
		return sizeDao.findAll();
	}

}
