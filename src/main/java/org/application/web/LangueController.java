package org.application.web;


import org.application.entities.Langue;
import org.application.service.CandidatMetierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class LangueController {

    @Autowired
    CandidatMetierImpl c;

    @GetMapping("/CandidatLangue")
    public String formLa(Model model) {
        model.addAttribute("langue",new Langue());
        return "candidat/CandidatLangues";}

    @PostMapping("/save_langue")
    public String addLangue(Langue langue, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){return "candidat/CandidatLangues";}
        c.createLangue(langue);
        return "redirect:/register";
    }

}