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
public class Langue implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long langue_id;
    private String langue_nom;
    private String langue_niveau;
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
