package org.application.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Candidats")
public class Candidat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(updatable = false, nullable = false)
    private Long candidat_id;
    //@Column(updatable = false, nullable = false)
    private String candidat_profil;
    //@Column(updatable = false, nullable = false)
    private String candidat_nom;
    //@Column(updatable = false, nullable = false)
    private String candidat_prenom;
    //@Column(updatable = false, nullable = false)
    private String candidat_sex;
    //@Column(updatable = false, nullable = false)
    private String candidat_email;
    //@Column(updatable = false, nullable = false)
    private String candidat_adresse;
    //@Column(updatable = false, nullable = false)
    //private String candidat_code_postal;
    //@Column(updatable = false, nullable = false)
    private String candidat_ville;
    //@Column(updatable = false, nullable = false)
    private String candidat_pays;
    //@Column(updatable = false, nullable = false)
    private String candidat_date_naissance;
    //@Column(updatable = false, nullable = false)
    private byte[] candidat_image;
    //@Column(updatable = false, nullable = false)
    private String candidat_phone;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user",referencedColumnName ="id")
    private User user;

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "candidat", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Experience> listExperiences = new ArrayList<Experience>();
    @OneToMany(mappedBy = "candidat", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Formation> listFormations = new ArrayList<Formation>();
    @OneToMany(mappedBy = "candidat", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Langue> listLangues = new ArrayList<Langue>();
    @OneToMany(mappedBy = "candidat", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Competence> listCompetences = new ArrayList<Competence>();

}
