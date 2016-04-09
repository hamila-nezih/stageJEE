package org.hn.stage.entities.demandes;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hn.stage.entities.base.BaseEntity;
import org.hn.stage.entities.typeDemandes.DocumentTypeDemande;

import com.mysql.jdbc.log.Log;

@Entity
@Table(name="document_dmd")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "dod_clef")) })
public class DocumentDemande extends BaseEntity{

	private static final long serialVersionUID = 3731906924467527265L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dod_dmd_clef", nullable = false) 
    private Demande demande ;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dod_dtd_clef", nullable = false)
	private DocumentTypeDemande documentTypeDemandes ;
	@Column(name="dod_libelle")
    private String libelle;    
    @Column(name="dod_nom_fichier")
    private String nomFichier ;
  //  terminer le type de fichier pour enregistrer dans la base de donner 
    @Lob
    @Column(name="dod_contenue",length=10000000)   
	private Log contenue ;
	
	public DocumentDemande(String libelle) {
		super();
		this.libelle = libelle;
	}

	public DocumentDemande() {
		super();
		// TODO Auto-generated constructor stub
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

	public void setContenue(Log contenue) {
		this.contenue = contenue;
	}	
    
}

