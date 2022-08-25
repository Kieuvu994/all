package com.coeding.springmvc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coeding.springmvc.entity.Rolez;
import com.coeding.springmvc.repository.RoleRepository;
import com.coeding.springmvc.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public void setCategoryRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	@Override
	public Rolez findById(int id) {
		// TODO Auto-generated method stub
		return this.roleRepository.findById(id);
	}

	@Override
	public List<Rolez> findAll() {
		// TODO Auto-generated method stub
		return this.roleRepository.findAll();
	}

	@Override
	public String create(Rolez pojo) {
		// TODO Auto-generated method stub
		return this.roleRepository.create(pojo);
	}

	@Override
	public String update(Rolez pojo) {
		// TODO Auto-generated method stub
		return this.roleRepository.update(pojo);
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		return this.roleRepository.delete(id);
	}

	@Override
	public Rolez findByRole(String role) {
		// TODO Auto-generated method stub
		return this.roleRepository.findByRole(role);
	}

}
