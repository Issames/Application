package org.application.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor @AllArgsConstructor @ToString
@Entity
public class Formation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long formation_id;
    private String formation_titre;
    private String diplome;
    private String etablisement;
    private String etablisement_ville;
    private String formation_debut;
    private String formation_fin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_candidat",referencedColumnName ="candidat_id", insertable = false, updatable = false)
    private Candidat candidat;
    public Candidat getCandidat() {
        return candidat;
    }
    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }


}