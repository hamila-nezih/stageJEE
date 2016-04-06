package org.hn.stage.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

import org.hn.stage.entities.base.BaseEntity;

@Entity
@Table(name="responsables")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "res_clef")) })
public class Responsable extends BaseEntity{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1551981328753707775L;

	
    @Column(name="res_libelle")
    private String libelle;
    @Column(name="res_nom")
    private String nom;
    @Column(name="res_prenom")
    private String prenom;

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

