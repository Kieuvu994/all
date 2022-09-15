package com.coeding.springmvc.repository.impl;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coeding.springmvc.entity.Rolez;
import com.coeding.springmvc.repository.RoleRepository;

@Repository
@Transactional
public class RoleRepositoryImpl implements RoleRepository {

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(RoleRepositoryImpl.class);

	@Autowired
	private SqlSessionFactory sessionFactory;
	
	public void setSessionFactory(SqlSessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public Rolez findById(int id) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		Rolez role = session.selectOne("mapper.role.findById", id);
		logger.info("Role ::"+role);
		return (role);
	}

	@Override
	public List<Rolez> findAll() {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		List<Rolez> userList = session.selectList("mapper.role.findAll");
		for(Rolez p : userList){
			logger.info("Role List::"+p);
		}
		return userList;
	}

	@Override
	public String create(Rolez pojo) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		session.insert("mapper.role.create", pojo);
		session.commit();
		logger.info("Create role::");
		return "Create role";
	}

	@Override
	public String update(Rolez pojo) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		session.update("mapper.role.update", pojo);
		session.commit();
		logger.info("Create role::");
		return "Create role";
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		session.delete("mapper.role.delete", id);
		session.commit();
		logger.info("delete role::");
		return "delete role";
	}

	@Override
	public Rolez findByRole(String r) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		Rolez role = session.selectOne("mapper.role.findByRole", r);
		logger.info("findByRole ::"+role);
		return (role);
	}

}
