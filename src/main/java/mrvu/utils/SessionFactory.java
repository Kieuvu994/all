package mrvu.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mrvu.dao.PlayerDao;
import mrvu.dao.TeamDao;

public class SessionFactory {

	private static SqlSessionFactory sessionFactory;
	private static SqlSession sqlSession;

	static {
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			Configuration configuration = sessionFactory.getConfiguration();

			// khai bao Dao
			configuration.addMapper(PlayerDao.class);
			configuration.addMapper(TeamDao.class);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static <T> T getMapper(Class<T> clazz) {
		sqlSession = sessionFactory.openSession();
		return sqlSession.getMapper(clazz);
	}

	public static void commit() {
		
		sqlSession.commit();
	}
//	public static void close() {
//		sqlSession.close();
//	}
}
