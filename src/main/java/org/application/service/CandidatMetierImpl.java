package org.application.service;



import org.application.Repository.*;
import org.application.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CandidatMetierImpl implements CandidatMetier {
    @Autowired
    CandidatRepository candidatRepository;
    @Autowired
    CompetenceRepository competenceRepository;
    @Autowired
    FormationRepository formationRepository;
    @Autowired
    ExperienceRepository experienceRepository;
    @Autowired
    LangueRepository langueRepository;


    @Override
    public void createCandidat(Candidat candidat) {
        candidatRepository.save(candidat);
    }

    @Override
    public void deleteCandidat(Long candidat_id) {
        candidatRepository.deleteById(candidat_id);

    }

    @Override
    public void updateCandidat(Candidat candidat, Long candidat_id) {
        candidatRepository.save(candidat);

    }

    @Override
    public void createLangue(Langue langue) {
        langueRepository.save(langue);

    }

    @Override
    public void updateLangue(Long langue_id, Langue langue) {
        langueRepository.save(langue);
    }

    @Override
    public void deleteLangue(Long langue_id) {
        langueRepository.deleteById(langue_id);

    }

    @Override
    public List<Langue> getAllLangueByCandidatId() {

        return langueRepository.findAll();
    }

    @Override
    public void createFormation(Formation formation) {
        formationRepository.save(formation);

    }

    @Override
    public void updateFormation(Long formation_id, Formation formation) {
        formationRepository.save(formation);

    }

    @Override
    public void deleteFormation(Long formation_id) {
        formationRepository.deleteById(formation_id);

    }

    @Override
    public List<Formation> getAllFormationByCandidatId() {
        return formationRepository.findAll();
    }

    @Override
    public void createCompetence(Competence comptence) {
        competenceRepository.save(comptence);

    }

    @Override
    public void updateCompetence(Long competence_id, Competence competence) {
        competenceRepository.save(competence);

    }

    @Override
    public void deleteCompetence(Long competence_id) {
        competenceRepository.deleteById(competence_id);

    }

    @Override
    public List<Competence> getAllCompetenceByCandidatId() {

        return competenceRepository.findAll();
    }

    @Override
    public void createExperience(Experience experience) {
        experienceRepository.save(experience);

    }

    @Override
    public void updateExperience(Long experience_id, Experience experience) {
        experienceRepository.save(experience);
    }

    @Override
    public void deleteExperience(Long experience_id) {
        experienceRepository.deleteById(experience_id);

    }

    @Override
    public List<Experience> getAllExperienceByCandidatId() {
        return experienceRepository.findAll();
    }
}
