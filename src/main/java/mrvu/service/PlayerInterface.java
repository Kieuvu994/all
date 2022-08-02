package mrvu.service;

import java.util.List;

import mrvu.entity.Player;
import mrvu.entity.Team;


public interface PlayerInterface {
	List<Player> listPlayer();
	void insertPlayer(Player Player) ;
	Player findPlayer(int no) ;
	void updatePlayer(Player player2) ;
}
