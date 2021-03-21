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
public class Experience implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long experience_id;
    private String experience_poste;
    private String secteur_activite;
    private String experience_debut;
    private String experience_fin;

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