package org.application.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Offre {
	@Id @GeneratedValue
	private Long id;
	@Column
	private Date dateCeation;
	private String poste;
	private String description;
	public Offre() {
		
	}
	public Offre(Long id, Date dateCeation, String poste, String description) {
		super();
		this.id = id;
		this.dateCeation = dateCeation;
		this.poste = poste;
		this.description = description;
	}
	public Offre(Date dateCeation, String poste, String description) {
		super();
		this.dateCeation = dateCeation;
		this.poste = poste;
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateCeation() {
		return dateCeation;
	}
	public void setDateCeation(Date dateCeation) {
		this.dateCeation = dateCeation;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
