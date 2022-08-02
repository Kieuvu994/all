package mrvu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import mrvu.entity.Player;
//@Repository
public interface PlayerDao {

	@Select("SELECT * FROM player")
	List<Player> selectList();
	
	@Select("SELECT * FROM player where pk= #{no}")
	Player selectOne(int no); 

	@Insert("INSERT INTO player (name, position, team_pk ) VALUES (#{name}, #{position},#{team_pk})")
	// @Options(useGeneratedKeys = true, keyProperty = "id")
	void insert(Player player);


	@Update("UPDATE player SET NAME = #{name}, position = #{position}, team_pk=#{team_pk} WHERE pk = #{pk}")
	void update(Player player);
	

}
