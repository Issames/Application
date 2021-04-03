package org.application.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Recruteurs")
public class Recruteur  implements Serializable  {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(nullable = false, length = 50)
	private String company_name;
	@Column(nullable = false, length = 50)
	private String company_speciality;
	@Column(nullable = false, length = 10)
	private String recruteur_phone;
	@Column(nullable = false, length = 250)
	private String company_url;
	@Column(nullable = false, length = 50)
	private String recruteur_firstname;
	@Column(nullable = false, length = 50)
	private String recruteur_lastname;
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private String photo;
	
	@OneToMany(mappedBy = "recruteur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Offre> listOffres = new ArrayList<Offre>();
	
	public List<Offre> getListOffres() {
		return listOffres;
	}
	public void setListOffres(List<Offre> listOffres) {
		this.listOffres = listOffres;
        listOffres.forEach(entity -> entity.setRecruteur(this));

        
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	/*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")*/
    private String email_user;
    
    //private Collection<Offre> offers;

	
	
	
	public String getEmailUser() {
		return email_user;
	}
	public void setEmailUser(String email_user) {
		
		this.email_user=email_user;
		
	    
		
	}
	
	public Recruteur() {}
	public Recruteur(String company_name,String company_speciality,
			String recruteur_phone,String company_url,String recruteur_firstname,String recruteur_lastname,String photo) 
	{
		
		this.company_name=company_name;
		this.company_speciality=company_speciality;
		this.recruteur_phone=recruteur_phone;
		this.company_url=company_url;
		this.recruteur_firstname=recruteur_firstname;
		this.recruteur_lastname=recruteur_lastname;
		this.photo=photo;
		
	}
	
	
	
	 public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCompany_speciality() {
		return company_speciality;
	}
	public void setCompany_speciality(String company_speciality) {
		this.company_speciality = company_speciality;
	}
	public String getRecruteur_phone() {
		return recruteur_phone;
	}
	public void setRecruteur_phone(String recruteur_phone) {
		this.recruteur_phone = recruteur_phone;
	}
	public String getCompany_url() {
		return company_url;
	}
	public void setCompany_url(String company_url) {
		this.company_url = company_url;
	}
	public String getRecruteur_firstname() {
		return recruteur_firstname;
	}
	public void setRecruteur_firstname(String recruteur_firstname) {
		this.recruteur_firstname = recruteur_firstname;
	}
	public String getRecruteur_lastname() {
		return recruteur_lastname;
	}
	public void setRecruteur_lastname(String recruteur_lastname) {
		this.recruteur_lastname = recruteur_lastname;
	}
}
