package org.hc.stage.entities.acteurs;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

import org.hc.stage.entities.base.BaseEntity;

@Entity
@Table(name="utilisateurs")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "res_clef")) })
public class Utilisateur extends BaseEntity{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1551981328753707775L;

	
    @Column(name="res_libelle")
    private String libelle;
    @Column(name="res_nom")
    private String nom;
    public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name="res_prenom")
    private String prenom;

	public Utilisateur(String libelle, String nom, String prenom) {
		super();
		this.libelle = libelle;
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
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


    
}

