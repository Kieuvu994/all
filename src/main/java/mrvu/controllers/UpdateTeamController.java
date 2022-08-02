package mrvu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
public class UpdateTeamController {
	@Autowired
	private PlayerInterface playerInterface;
	@Autowired
	private TeamInterface teamInterface;
	

	@GetMapping("/team/update")
	public String pk(
			Model model,
			@RequestParam("pk") String pk) {
		model.addAttribute("pk", pk);
		return "teamForm";
		
	}
	@PostMapping("/team/updateForm")
	public String team(
			Model model,
			@RequestParam("pk") String pk,
			@RequestParam("name") String name
			) {
		Team player=new Team();
		player.setPk(Integer.valueOf(pk));
		player.setName(name);
	
		teamInterface.updateTeam(player);
		
		List<Team> teams = teamInterface.listTeam();
		List<Player> players = playerInterface.listPlayer();
		
	//	System.out.println(teams);

		model.addAttribute("teams", teams);
		model.addAttribute("players", players);
		 
		return "home";
	}
}
