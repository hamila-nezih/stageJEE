package org.hn.stage.entities.acteurs;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hn.stage.entities.base.BaseEntity;


@Entity
@Table(name="services")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "srv_clef")) })
public class Utilisateur extends BaseEntity{

	private static final long serialVersionUID = -1781951653776269042L;
	@Column(name="srv_libelle")
    private String libelle;
	@Column(name="srv_nom")
    private String nom;
	@Column(name="srv_prenom")
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

