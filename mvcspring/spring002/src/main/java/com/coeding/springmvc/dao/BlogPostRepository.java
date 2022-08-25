package com.coeding.springmvc.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeding.springmvc.entity.BlogPost;

/*
 * Spring Container 로부터 SqlSessionFactory 주입받아 사용
 */
@Repository
public class BlogPostRepository {

	private static final Logger logger = LoggerFactory.getLogger(BlogPostRepository.class);

	private SqlSessionFactory sqlFactory;
	
	public BlogPostRepository() {
		super();
	}
	@Autowired
	public BlogPostRepository(SqlSessionFactory sqlFactory) {
		this.sqlFactory = sqlFactory;
	}
	
	public List<BlogPost> findAll() {
		// DataSource.getConnetion
		SqlSession session = sqlFactory.openSession();
		List<BlogPost> list = session.selectList("blog.post.selectAll");
		session.close();
		return list;
	}

	public List<BlogPost> find(BlogPost arg) {
		return null;
	}

	public int insert(BlogPost arg) {
		SqlSession session = sqlFactory.openSession();
		session.insert("blog.post.insert", arg);
		session.commit();
		session.close();
		return 0;
	}

	public void update(BlogPost arg) {
		
	}

	public void delete(int id) {
		
	}

	public BlogPost findRecent() {
		SqlSession session = sqlFactory.openSession();
		BlogPost post = (BlogPost)session.selectOne("blog.post.recentOne");
		session.close();
		return post;
	}

}
