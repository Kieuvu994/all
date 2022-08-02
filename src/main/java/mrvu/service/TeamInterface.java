package mrvu.service;

import java.util.List;

import mrvu.entity.Team;


public interface TeamInterface {
	List<Team> listTeam();
	void insertTeam(Team Team) ;
	Team findTeam(int no) ;
	void updateTeam(Team Team2) ;
}
