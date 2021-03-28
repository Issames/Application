package org.application.service;

import java.io.IOException;
import java.util.Base64;

import org.application.Repository.RecruteurRepository;
import org.application.entities.Recruteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Service
public class RecruteurService {

	@Autowired
	RecruteurRepository recruteurRepository;
	
	
	
	public Recruteur modifierRecruteur(@RequestParam("id") long id,String Recruteur_firstname,String Recruteur_lastname)
	{
		Recruteur recFromDb = recruteurRepository.findById(id).get();
		recFromDb.setRecruteur_firstname(Recruteur_firstname);
		recFromDb.setRecruteur_firstname(Recruteur_lastname);
		recruteurRepository.save(recFromDb);
		return recFromDb;
	}
		
}
