package org.application.web;


import org.application.entities.Recruteur;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/RecruteurProfile")
	public String showRecruteur(Model model) {
		model.addAttribute("recruteur", new Recruteur());
		return "recruteur/Recreteur";
	}

	

}
