package org.application.web;


import org.application.entities.*;
import org.application.service.CandidatMetierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class FormationController {

    @Autowired
    CandidatMetierImpl c;

    @GetMapping("/CandidatFormation")
    public String formFo(Model model) {
        model.addAttribute("formation",new Formation());
        return "candidat/CandidatFormations";}

    @PostMapping("/save_formation")
    public String addFormation(Formation formation, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){return "candidat/CandidatFormations";}
        c.createFormation(formation);
        return "redirect:/CandidatExperience";
    }


}