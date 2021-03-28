package org.application.web;

import java.io.Console;
import java.io.IOException;
import java.util.Base64;

import org.application.Repository.RecruteurRepository;
import org.application.entities.Recruteur;
import org.application.service.RecruteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Component

@Controller
public class RecruiterController {
	@Autowired
	private RecruteurRepository recruiterRepository;
	private RecruteurService service;
	
	
	
	@PostMapping("/save_recruiter")
	public ModelAndView saveRecruiterToDB(@ModelAttribute MultipartFile file,String company_name, String company_speciality, 
		String recruteur_phone, String company_url, String recruteur_firstname, String recruteur_lastname/*,@RequestParam(name = "id_user") Long id_user*/) {
		
		Recruteur r = new Recruteur();
		
		String fileName= org.springframework.util.StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("File not valide");
		}
		try {
			r.setPhoto(Base64.getEncoder().encodeToString(file.getBytes()));
		}
		catch(IOException e){ e.printStackTrace();}
		
		
		r.setCompany_name(company_name);
		r.setCompany_speciality(company_speciality);
		r.setCompany_url(company_url);
		r.setRecruteur_phone(recruteur_phone);
		r.setRecruteur_firstname(recruteur_firstname);
		r.setRecruteur_lastname(recruteur_lastname);
		//r.setIdUser(id_user);
		
		recruiterRepository.save(r);
		ModelAndView mav = new ModelAndView("recruteur/MonProfile");
        mav.addObject("recruteur", r);
        return mav;
	}
	
/*	@GetMapping("/profile")
	public ModelAndView getProfile(@RequestParam("id")  Long id)
	{
		Recruteur recFromDb = recruiterRepository.findById(id).get();
		ModelAndView mav = new ModelAndView("recruteur/MonProfile");
        mav.addObject("recruteur", recFromDb);
        return mav;
	}
*/	
	@GetMapping("/modifierForm")
	public ModelAndView getProfileForm(@RequestParam("id")  Long id)
	{
		Recruteur recFromDb = recruiterRepository.findById(id).get();
		ModelAndView mav = new ModelAndView("recruteur/upProfile");
        mav.addObject("recruteur", recFromDb);
        return mav;
	}
	
    @Autowired
	RecruteurRepository recruteurRepository ;
	@PostMapping("/modifier")
	public ModelAndView modifier(@RequestParam("id") Long id,  String recruteur_firstname,String recruteur_lastname,String recruteur_phone, String company_url)
	{
		Recruteur recFromDb = recruteurRepository.findById(id).get();
		recFromDb.setRecruteur_firstname(recruteur_firstname);
		recFromDb.setRecruteur_lastname(recruteur_lastname);
		recFromDb.setRecruteur_phone(recruteur_phone);
		recFromDb.setCompany_url(company_url);
		Recruteur r =recruteurRepository.save(recFromDb);
		//Recruteur r=service.modifierRecruteur(id, recruteur_firstname,recruteur_lastname);
		ModelAndView mav = new ModelAndView("recruteur/MonProfile");
        mav.addObject("recruteur", r);
        return mav;
	}
	
}
