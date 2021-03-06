package com.hc.stage.entities.demandes;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hc.stage.entities.base.BaseEntity;
import com.hc.stage.entities.types.typesDeDemandes.PrerequisTypeDemande;


@Entity
@Table(name="prerequis_demandes")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "prd_clef")) })
public class PrerequisDeDemande extends BaseEntity{

    
	private static final long serialVersionUID = 2332737171236259159L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dmd_clef", nullable = false)
    private Demande demande ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prq_clef", nullable = false)
    private PrerequisTypeDemande prerequisTypeDemande ;
	
	@Column(name="prq_date_creation")
	private Date dateCreation;
	
	@Column(name="prd_libelle")
    private String libelle;

	public PrerequisDeDemande(String libelle) {
		super();
		this.libelle = libelle;
	}

	public PrerequisDeDemande() {
		super();
	}

	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

	public PrerequisTypeDemande getPrerequisTypeDemande() {
		return prerequisTypeDemande;
	}

	public void setPrerequisTypeDemande(PrerequisTypeDemande prerequisTypeDemande) {
		this.prerequisTypeDemande = prerequisTypeDemande;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
    
}

