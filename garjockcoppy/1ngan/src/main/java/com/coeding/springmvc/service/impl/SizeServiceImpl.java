package com.coeding.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coeding.springmvc.dao.SizeDao;
import com.coeding.springmvc.entity.Size;
import com.coeding.springmvc.service.SizeService;

@Service
public class SizeServiceImpl implements SizeService {

	@Autowired
	private SizeDao dao;
	
	@Override
	public Size getSizeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Size> listSize() {
		// TODO Auto-generated method stub
		return dao.getAllSize();
	}

}
