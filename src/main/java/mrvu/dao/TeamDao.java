package mrvu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import mrvu.entity.Team;
//@Repository
public interface TeamDao {

	@Select("SELECT * FROM team")
	List<Team> selectList();
	
	@Select("SELECT * FROM team where pk= #{no}")
	Team selectOne(int no); 

	@Insert("INSERT INTO team (name ) VALUES (#{name})")
	// @Options(useGeneratedKeys = true, keyProperty = "id")
	void insert(Team Team);


	@Update("UPDATE Team SET name = #{name} WHERE pk = #{pk}")
	void update(Team Team);
	

}
