package org.application.service;

import java.io.IOException;
import java.util.Base64;

import org.application.Repository.RecruteurRepository;
import org.application.entities.Recruteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Service
public class RecruteurService {

	@Autowired
	RecruteurRepository recruteurRepository;
	
	
	public void CreateRecruiter(Recruteur r)
	{
			
		
			
			/*
			r.setCompany_name(company_name);
			r.setCompany_speciality(company_speciality);
			r.setCompany_speciality(company_speciality);
			r.setCompany_url(company_url);
			r.setRecruteur_phone(recruteur_phone);
			r.setRecruteur_firstname(recruteur_firstname);
			r.setRecruteur_lastname(recruteur_lastname);
			/*r.setIdUser(id_user);*/
			
			recruteurRepository.save(r);
			
	}
		public void SaveProfilePicture(@ModelAttribute MultipartFile file)
		{
			String fileName= org.springframework.util.StringUtils.cleanPath(file.getOriginalFilename());
			if(fileName.contains(".."))
			{
				System.out.println("File not valide");
			}
			//try {
				//recruteurRepository.setPhoto(Base64.getEncoder().encodeToString(file.getBytes()));
			//}
			//catch(IOException e){ e.printStackTrace();}
			
		}
		
}
