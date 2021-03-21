package org.application.service;

import org.application.entities.*;

import java.util.List;

public interface CandidatMetier {

    public void createCandidat(Candidat candidat);

    public void deleteCandidat(Long candidat_id);

    public void updateCandidat(Candidat candidat,Long candidat_id);

    public void createLangue(Langue langue);

    public void updateLangue(Long langue_id,Langue langue);

    public void deleteLangue(Long langue_id);

    public List<Langue> getAllLangueByCandidatId();

    public void createFormation(Formation formation);

    public void updateFormation(Long formation_id,Formation formation);

    public void deleteFormation(Long formation_id);

    public List<Formation> getAllFormationByCandidatId();

    public void createCompetence(Competence comptence);

    public void updateCompetence(Long competence_id,Competence competence);

    public void deleteCompetence(Long competence_id);

    public List<Competence> getAllCompetenceByCandidatId();

    public void createExperience(Experience experience);

    public void updateExperience(Long experience_id,Experience experience);

    public void deleteExperience(Long experience_id);

    public List<Experience> getAllExperienceByCandidatId();





}
