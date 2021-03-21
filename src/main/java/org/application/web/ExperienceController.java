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
public class ExperienceController {

    @Autowired
    CandidatMetierImpl c;

    @GetMapping("/CandidatExperience")
    public String formEx(Model model) {
        model.addAttribute("experience",new Experience());
        return "candidat/CandidatExperiences";}


    @PostMapping("/save_experience")
    public String addExperience(Experience experience, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){return "candidat/CandidatExperiences";}
        c.createExperience(experience);
        return "redirect:/CandidatCompetence";
    }


}