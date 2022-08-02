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

import com.coeding.springmvc.entity.BlogPost;

/**
 * 
 * step 4. mybatis xml 설정으로부터 직접 생성 후 사용
 * 
 * @author coeding
 *
 */
public class BlogPostDao {
	private static final Logger logger = LoggerFactory.getLogger(BlogPostDao.class);

	private static SqlSessionFactory sqlFactory;
	
	public BlogPostDao() {
		sqlFactory = getSqlSessionFactory();
	}
	private static SqlSessionFactory getSqlSessionFactory() {
		if( sqlFactory == null ) {
			String resource = "mybatis/mybatis-config.xml";
			Reader rd=null;
			try {
				// ctx.lookup
				rd = Resources.getResourceAsReader(resource);
				sqlFactory = new SqlSessionFactoryBuilder().build(rd);
				logger.info("{}", sqlFactory);
			} catch (IOException e) {
				e.printStackTrace();
			} 
			if(rd!=null) {
				try {
					rd.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sqlFactory;
	}

	public BlogPost findOne(int id) {
		// TODO Auto-generated method stub
		return null;
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
		// sql ? SELECT * FROM blog_post ORDER BY id desc LIMIT 1;
		SqlSession session = sqlFactory.openSession();
		BlogPost post = (BlogPost)session.selectOne("blog.post.recentOne");
		session.close();
		return post;
	}

}
