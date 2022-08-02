package mrvu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mrvu.dao.PlayerDao;
import mrvu.dao.TeamDao;
import mrvu.utils.SessionFactory;
import mrvu.entity.Player;
import mrvu.entity.Team;
@Service
public class serviceIMPL implements PlayerInterface {
	
	private TeamDao TeamDao;
	private PlayerDao playerDao;
	{
		TeamDao = SessionFactory.getMapper(TeamDao.class);
		playerDao = SessionFactory.getMapper(PlayerDao.class);
	}
	@Override
	public List<Player> listPlayer() {
		// TODO Auto-generated method stub
		return playerDao.selectList();
	}
	@Override
	public void insertPlayer(Player Player) {
		// TODO Auto-generated method stub
		playerDao.insert(Player);
	}
	@Override
	public Player findPlayer(int no) {
		// TODO Auto-generated method stub
		return playerDao.selectOne(no);
	}
	@Override
	public void updatePlayer(Player player2) {
		// TODO Auto-generated method stub
		playerDao.update(player2);
	}
	
	////////////////////////////////////////////////////////
	//@Override
	public List<Team> listTeam() {
		// TODO Auto-generated method stub
		return TeamDao.selectList();
	}
	//@Override
	public void insertTeam(Team Team) {
		// TODO Auto-generated method stub
		TeamDao.insert(Team);
	}
	//@Override
	public Team findTeam(int no) {
		// TODO Auto-generated method stub
		return TeamDao.selectOne(no);
	}
	//@Override
	public void updateTeam(Team Team2) {
		// TODO Auto-generated method stub
		TeamDao.update(Team2);
	}
	
}
