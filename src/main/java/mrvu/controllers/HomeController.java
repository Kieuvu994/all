package mrvu.controllers;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import mrvu.entity.Player;
import mrvu.entity.Team;
import mrvu.service.*;




@Controller
public class HomeController {

	@Autowired
	private PlayerInterface playerInterface;
	@Autowired
	private TeamInterface teamInterface;

	@GetMapping("/")
	public String home(Model model) {
//		Team team=new Team(1,"Sài Gòn");
//		System.out.println(team);
//		teamInterface.insert(team);
		List<Team> teams = teamInterface.listTeam();

		List<Player> players = playerInterface.listPlayer();
		
	//	System.out.println(teams);

		model.addAttribute("teams", teams);
		model.addAttribute("players", players);

		return "home";
	}




}
