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

import com.hc.stage.entities.base.BaseEntity;
import com.hc.stage.entities.types.typesDeDemandes.DocumentTypeDemande;

@Entity
@Table(name="documents_demandes")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "dod_clef")) })
public class DocumentDeDemande extends BaseEntity{

	private static final long serialVersionUID = 3731906924467527265L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dmd_clef", nullable = false) 
    private Demande demande;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dtd_clef", nullable = false)
	private DocumentTypeDemande documentTypeDemandes;
	
	@Column(name="dod_date_creation")
	private Date dateCreation;
	
	@Column(name="dod_libelle")
    private String libelle;
	
    @Column(name="dod_nom_fichier")
    private String nomFichier ;
    
    
    // TODO vérifier s'il existe un type générique pour les autres bases 
    
    @Column(name="dod_contenue",columnDefinition = "LONGBLOB")   
	private byte [] contenue ;
	
	public DocumentDeDemande(String libelle) {
		super();
		this.libelle = libelle;
	}

	public DocumentDeDemande() {
		super();
	}

	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

	public DocumentTypeDemande getDocumentTypeDemandes() {
		return documentTypeDemandes;
	}

	public void setDocumentTypeDemandes(DocumentTypeDemande documentTypeDemandes) {
		this.documentTypeDemandes = documentTypeDemandes;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getNomFichier() {
		return nomFichier;
	}

	public void setNomFichier(String nomFichier) {
		this.nomFichier = nomFichier;
	}

	
	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public byte[] getContenue() {
		return contenue;
	}

	public void setContenue(byte[] contenue) {
		this.contenue = contenue;
	}

	
}

