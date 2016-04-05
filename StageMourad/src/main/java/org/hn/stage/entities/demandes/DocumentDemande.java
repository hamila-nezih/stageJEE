package org.hn.stage.entities.demandes;
/*
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hn.stage.entities.base.BaseEntity;
import org.hn.stage.entities.typeDemandes.DocumentTypeDemande;

@Entity
@Table(name="document_dmd")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "dod_clef")) })
public class DocumentDemande extends BaseEntity{

	private static final long serialVersionUID = 3731906924467527265L;

	@Column(name="dod_libelle")
    private String libelle;    
    @Column(name="dod_nom_fichier")
    private String nomFichier ;
    
    // terminer le type de fichier pour enregistrer dans la base de donner 
    @Column(name="dod_contenue")
    private String contenue ;
    @ManyToOne
    @Column(name="dod_dtd_clef")
	@JoinColumn(name="dtd_clef")    
    private DocumentTypeDemande documentTypeDemandes ;
    @ManyToOne
    @Column(name="dod_dmd_clef")
	@JoinColumn(name="dmd_clef")    
    private Demande demande ;

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

	public String getContenue() {
		return contenue;
	}

	public void setContenue(String contenue) {
		this.contenue = contenue;
	}

	public DocumentTypeDemande getDocumentTypeDemandes() {
		return documentTypeDemandes;
	}

	public void setDocumentTypeDemandes(DocumentTypeDemande documentTypeDemandes) {
		this.documentTypeDemandes = documentTypeDemandes;
	}

	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

	
    
}*/

