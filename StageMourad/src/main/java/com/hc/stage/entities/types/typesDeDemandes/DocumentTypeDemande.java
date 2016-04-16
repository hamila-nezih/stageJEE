package com.hc.stage.entities.types.typesDeDemandes;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hc.stage.entities.acteurs.Utilisateur;
import com.hc.stage.entities.base.BaseEntity;

@Entity
@Table(name="types_documents")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "dtd_clef")) })
public class DocumentTypeDemande extends BaseEntity{

	
	private static final long serialVersionUID = 6980861635976314154L;
	
	@ManyToOne
	@JoinColumn(name="tyd_clef",referencedColumnName="tyd_clef")
	private TypeDemande typeDemande;
	
	@Column(name="dtd_libelle")
	private String libelle;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uti_clef", nullable = false)
	private Utilisateur utilisateur;
	
	@Column(name="dtd_obligatoire")
	private Boolean obligatoire;
	
	public DocumentTypeDemande(String libelle, Boolean obligatoire,TypeDemande typeDemande) {
		super();
		this.typeDemande = typeDemande;
		this.libelle = libelle;
		this.obligatoire = obligatoire;
	}
	
	public DocumentTypeDemande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeDemande getTypeDemande() {
		return typeDemande;
	}

	public void setTypeDemande(TypeDemande typeDemande) {
		this.typeDemande = typeDemande;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Boolean getObligatoire() {
		return obligatoire;
	}

	public void setObligatoire(Boolean obligatoire) {
		this.obligatoire = obligatoire;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public DocumentTypeDemande(String libelle, Boolean obligatoire) {
		super();
		this.libelle = libelle;
		this.obligatoire = obligatoire;
	}
}
