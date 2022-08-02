package mrvu.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import mrvu.dto.SizeDto;
import mrvu.interfaces.SizeService;
import mrvu.jpa.Size;

public class SizeServiceVu01 implements SizeService {
	
	private SqlSession session;
	
	@Autowired
	public void setSqlSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<Size> list() {
		return session.selectList("mrvu.size.listSize");
	}

	@Override
	public String add(SizeDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(SizeDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

}
