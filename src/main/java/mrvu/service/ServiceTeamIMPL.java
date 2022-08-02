package mrvu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mrvu.dao.PlayerDao;
import mrvu.dao.TeamDao;
import mrvu.utils.SessionFactory;
import mrvu.entity.Player;
import mrvu.entity.Team;
@Service
public class ServiceTeamIMPL implements TeamInterface {
	
	private TeamDao TeamDao;
	
	{
		TeamDao = SessionFactory.getMapper(TeamDao.class);
	}
	@Override
	public List<Team> listTeam() {
		// TODO Auto-generated method stub
		return TeamDao.selectList();
	}
	@Override
	public void insertTeam(Team Team) {
		// TODO Auto-generated method stub
		TeamDao.insert(Team);
		SessionFactory.commit();
	}
	@Override
	public Team findTeam(int no) {
		// TODO Auto-generated method stub
		return TeamDao.selectOne(no);
	}
	@Override
	public void updateTeam(Team Team2) {
		// TODO Auto-generated method stub
		TeamDao.update(Team2);
		SessionFactory.commit();
	}
	
}
