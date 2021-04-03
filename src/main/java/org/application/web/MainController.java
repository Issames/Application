package org.application.web;


import org.application.entities.Candidat;
import org.application.entities.Recruteur;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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
	public String showRecruteur(Model model, String email) {
		model.addAttribute("recruteur", new Recruteur());
		model.addAttribute("email",email);
		return "recruteur/Recreteur";
	}

	 @GetMapping("/CandidatProfile")
	    public String formPr(@ModelAttribute Model model) {
	        model.addAttribute("candidat",new Candidat());
	        return "candidat/CandidatProfile";
	        }

}
