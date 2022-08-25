package com.coeding.springmvc.pojo;

import java.sql.Connection;
import java.sql.SQLException;

import com.coeding.springmvc.utils.DataSourceFactory;

public class UseJDBC {

	public static void main(String[] args) {
		// TODO: DB step 1. JDBC test
		step01JDBCconnector();
		step02SpringJDBC();

	}

	private static void step02SpringJDBC() {
		// TODO: to test, remove @Deprecated DataSourceFactory
		try(Connection con = DataSourceFactory.getConnection("jdbc:mysql://localhost:3306/blog", "root", "")){
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private static void step01JDBCconnector() {
		// TODO Auto-generated method stub
		try(Connection con = DataSourceFactory.getMysqlConnection("jdbc:mysql://localhost:3306/blog", "root", "")){
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}
