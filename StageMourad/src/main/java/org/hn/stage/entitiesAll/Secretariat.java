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
@Table(name="Secretariats")
public class Secretariat implements Serializable
 {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idSec ;
	private String nom ;
	private String prenom ;
	private String login ;
	private String motPasse ;
	@OneToMany(mappedBy="secretariat")
	private Collection<TraitementDmd> traitementDmds = new ArrayList<TraitementDmd>();
	@OneToMany(mappedBy="secretariat")
	private Collection<CreationOffre> creationOffres = new ArrayList<CreationOffre>();
	
	public Secretariat(String nom, String prenom, String login, String motPasse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.motPasse = motPasse;
	}

	public Long getIdSec() {
		return idSec;
	}

	public void setIdSec(Long idSec) {
		this.idSec = idSec;
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

	public Secretariat() {
		// TODO Auto-generated constructor stub
	}

}
