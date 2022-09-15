package com.coeding.springmvc.service;

import java.util.List;

import com.coeding.springmvc.entity.Size;


/**
 * 
 * @author Quan
 *
 */
public interface SizeService {
	Size findById(int id);
	List<Size> findAll();
}
