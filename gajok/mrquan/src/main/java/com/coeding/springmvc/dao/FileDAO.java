package com.coeding.springmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeding.springmvc.dto.FileDTO;

@Repository
public class FileDAO {

	// TODO: spring+mybatis
	private SqlSessionFactory sessionFac;
	
	@Autowired
	public void setSqlSession(SqlSessionFactory sessionFac) {
		this.sessionFac = sessionFac;
	}
	
	public int insertFile(FileDTO dto) {
		int re = 0;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO fileboard(name,pwd,title,content,filename,filesize) VALUES(?,?,?,?,?,?)";
		try {
			SqlSession session=sessionFac.openSession();
			con = session.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getPwd());
			ps.setString(3, dto.getTitle());
			ps.setString(4, dto.getContent());
			ps.setString(5, dto.getFileName());
			ps.setLong(6, dto.getFileSize());
			re = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // try - catch - finally
		return re;
	} // insertFile()
	
	public ArrayList<FileDTO> listFile() {
		ArrayList<FileDTO> list = new ArrayList<FileDTO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT name,title,content,filename,filesize FROM fileboard";
		try {
			SqlSession session=sessionFac.openSession();
			con = session.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				FileDTO dto = new FileDTO();
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setFileName(rs.getString("filename"));
				dto.setFileSize(rs.getLong("filesize"));
				list.add(dto);
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // try - catch - finally
		return list;
	} // listFile()

	
}
