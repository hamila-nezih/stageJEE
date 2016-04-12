package org.hc.stage.entities.historisation.historisationDesDemandes;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hc.stage.entities.base.BaseEntity;
import org.hc.stage.entities.types.typesDeDemandes.DocumentTypeDemande;

import com.mysql.jdbc.log.Log;


@Entity
@Table(name="historique_doc_demandes")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "hdd_clef")) })
public class HistoriqueDocumentDemande extends BaseEntity {
	
	private static final long serialVersionUID = -8090461535242541173L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hdm_clef", nullable = false)	
	private HistoriqueDemande  historiqueDemande;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dtd_clef", nullable = false)	
	private DocumentTypeDemande documentTypeDemande;
	
	 @Lob
	 @Column(name="dod_contenue",length=10000000)   
	 private Log contenue ;
	 
	 public HistoriqueDocumentDemande() {
			super();
		}

	 public HistoriqueDemande getHistoriqueDemande() {
		return historiqueDemande;
	 }

	 public void setHistoriqueDemande(HistoriqueDemande historiqueDemande) {
		this.historiqueDemande = historiqueDemande;
	 }

	 public DocumentTypeDemande getDocumentTypeDemande() {
		return documentTypeDemande;
     }

	 public void setDocumentTypeDemande(DocumentTypeDemande documentTypeDemande) {
		this.documentTypeDemande = documentTypeDemande;
	 }

	 public Log getContenue() {
		return contenue;
	 }

	 public void setContenue(Log contenue) {
		this.contenue = contenue;
	 }

	 public HistoriqueDocumentDemande(HistoriqueDemande historiqueDemande, DocumentTypeDemande documentTypeDemande,
			Log contenue) {
		super();
		this.historiqueDemande = historiqueDemande;
		this.documentTypeDemande = documentTypeDemande;
		this.contenue = contenue;
	 }
	 
	
}
