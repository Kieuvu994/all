package mrvu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mrvu.entity.Player;
import mrvu.entity.Team;
import mrvu.service.PlayerInterface;
import mrvu.service.TeamInterface;

/**
 * 
 * 
 *
 */
@Controller
public class AddTeamController {
	@Autowired
	private PlayerInterface playerInterface;
	@Autowired
	private TeamInterface teamInterface;
	

	@GetMapping("/team/add")
	public String team(
			Model model,
			@RequestParam("name") String name) {
		Team team=new Team(0,name);
		teamInterface.insertTeam(team);
		List<Team> teams = teamInterface.listTeam();

	
		List<Player> players = playerInterface.listPlayer();
		
	//	System.out.println(teams);

		model.addAttribute("teams", teams);
		model.addAttribute("players", players);
		 
		return "home";
	}

}
