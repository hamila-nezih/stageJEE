package org.hn.stage.entitiesAll;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Directeurs")
public class Directeur implements Serializable
 {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idDec ;
	private String nom ;
	private String prenom ;
	private String login ;
	private String motPasse ;
	@OneToMany(mappedBy="directeur")
	private Collection<TraitementDmd> traitementDmds = new ArrayList<TraitementDmd>();
	public Directeur() {
		// TODO Auto-generated constructor stub
	}
	public Long getIdDec() {
		return idDec;
	}
	public void setIdDec(Long idDec) {
		this.idDec = idDec;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotPasse() {
		return motPasse;
	}
	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}
	public Collection<TraitementDmd> getTraitementDmds() {
		return traitementDmds;
	}
	public void setTraitementDmds(Collection<TraitementDmd> traitementDmds) {
		this.traitementDmds = traitementDmds;
	}

 }

