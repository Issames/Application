package org.application.service;

import java.util.List;

import org.application.Repository.OfferRepository;
import org.application.entities.Offre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OffreService {

	@Autowired
	private OfferRepository offreRepository;
	
	 
	    public List < Offre > findAll() {
	        return offreRepository.findAll();
	    }
	    
	    public void delete(long id) {
	    	offreRepository.deleteById(id);
	    }
}
