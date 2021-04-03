package org.application.web;

import java.util.List;

import org.application.Repository.OfferRepository;
import org.application.Repository.RecruteurRepository;
import org.application.entities.Candidat;
import org.application.entities.Offre;
import org.application.entities.Recruteur;
import org.application.service.OffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Component
@Controller
public class OffreController {

	@Autowired
	private OfferRepository offerRepository;
    @Autowired
	private OffreService offreService;
    
    
	@GetMapping("/offre")
	public String showRecruteur(Model model) {
		model.addAttribute("offre", new Offre());
		return "offres/offre";
	}
	
	/*@PostMapping("/save_offre")
    public ModelAndView addOffer(Offre offre, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
        {
        ModelAndView mav = new ModelAndView("offres/offre");
        return mav;
        }
        offerRepository.save(offre);
        ModelAndView mav = new ModelAndView("offres/home");
        mav.addObject("offers", offreService.findAll());
        return mav;
    }
	*/
	@PostMapping("/save_offre")
    public String addOffer(Model model,Offre offre, BindingResult bindingResult) {
       // if(bindingResult.hasErrors()) {return "offres/offre";}
        offerRepository.save(offre);
		model.addAttribute("offres", offreService.findAll());
		return "offres/home";
    }
    @RequestMapping(value="/mesOffres", method= RequestMethod.GET)
	public String show(Model model)
	{
		
		model.addAttribute("offres", offreService.findAll());
		return "offres/home";
	}
    
    @GetMapping("/supprimer")
	public ModelAndView delete(@RequestParam("id")  Long id )
	{
		
		
    	offreService.delete(id);
		
		ModelAndView mav = new ModelAndView("offres/home");
		mav.addObject("services", offreService.findAll());
        return mav;
		
		
	}
}
