package org.application.web;


import org.application.entities.*;
import org.application.service.CandidatMetierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CandidatController {

    @Autowired
    CandidatMetierImpl c;

   /* @GetMapping("/CandidatProfile")
    public String formPr(@ModelAttribute Model model) {
        model.addAttribute("candidat",new Candidat());
        return "candidat/CandidatProfile";
        }
	*/
    @PostMapping("/save_profile")
    public String addProfile(Candidat candidat, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){return "candidat/CandidatProfile";}
        c.createCandidat(candidat);
        return "redirect:/CandidatFormation";
    }


}