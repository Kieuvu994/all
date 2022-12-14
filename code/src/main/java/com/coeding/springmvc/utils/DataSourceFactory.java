package com.coeding.springmvc.utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class DataSourceFactory {

	  // JDBC driver name and database URL
	   static final String JDBC_MYSQL_DRIVER1 = "com.mysql.jdbc.Driver";  
	   static final String JDBC_MYSQL_DRIVER2 = "com.mysql.cj.jdbc.Driver";  
	   static final String JDBC_ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";  
	   static final String JDBC_DB2_DRIVER = "com.ibm.db2.jdbc.net.DB2Driver";  
	   static final String JDBC_SYBASE_DRIVER = "com.sybase.jdbc.SybDriver";

	   static final String DB_MYSQL_URL = "jdbc:mysql://localhost:port Number/EMP";
	   static final String DB_ORACLE_URL = "jdbc:oracle:thin:@hostname:port Number:databaseName";
	   static final String DB_DB2_URL	= "jdbc:db2:hostname:port Number/databaseName";
	   static final String DB_SYBASE_URL = "jdbc:sybase:Tds:hostname: port Number/databaseName";

	   static final String USER = "username";
	   static final String PASS = "password";
	   
	   /**
	    * use JDBC
	    * 
	    * @param url
	    * @param username
	    * @param password
	    * @return
	    */
	   public static Connection getMysqlConnection(String url, String username, String password) {
		   Connection conn = null;
		   try{
		      Class.forName(JDBC_MYSQL_DRIVER2);
	
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(url,username,password);
		      return conn;
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		   }//end try
		   return null;
	   }//end
	   
	   /**
	    * Spring JDBC
	    * @param url
	    * @param username
	    * @param password
	    * @return
	    */
	   public static Connection getConnection(String url, String username, String password) {
			try {
				Class<Driver> driverClass = (Class<Driver>)Class.forName("com.mysql.cj.jdbc.Driver");
				SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
				// DB ??? ?????? ????????? ???????????? ????????? ?????? ??? ??????
				dataSource.setDriverClass(driverClass);
				dataSource.setUrl(url);
				dataSource.setUsername(username);
				dataSource.setPassword(password);
				
//				DataSource datasource = new SimpleDriverDataSource(driverClass, url, username, password);
				System.out.println( new JdbcTemplate(dataSource) );
				Connection conn = dataSource.getConnection();
				return conn;
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return null;
	   }//end
	

}
