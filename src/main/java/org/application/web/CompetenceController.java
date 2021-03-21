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
public class CompetenceController {

    @Autowired
    CandidatMetierImpl c;

    @GetMapping("/CandidatCompetence")
    public String formCo(Model model) {
        model.addAttribute("competence",new Competence());
        return "candidat/CandidatCompetences";}


    @PostMapping("/save_competence")
    public String addCompetence(Competence competence, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){return "candidat/CandidatCompetences";}
        c.createCompetence(competence);
        return "redirect:/CandidatLangue";
    }


}