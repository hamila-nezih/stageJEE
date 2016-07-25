package com.hc.stage.entities.historisation.historisationDesDemandes;

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
import com.hc.stage.entities.demandes.Demande;

@Entity
@Table(name="historique_demandes")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "hdm_clef")) })
public class HistoriqueDemande extends BaseEntity{

	private static final long serialVersionUID = -7993255878282588813L;
	
	//type historique nous permet d'avoir est ce que l'historique conserne document,prerequi ou demande
	
	@Column(name="hdm_type_hist")
	private String typeHist;
		
	@Column(name="hdm_date")
	private Date dateHist;
	
	@Column(name = "hdm_commentaire")
	private String commentaire;
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hdm_dmd_clef", nullable = false)	
	private Demande demande;
	
	public HistoriqueDemande() {
		super();
	}
	
	public HistoriqueDemande(String typeHist, Date dateHist) {
		super();
		this.typeHist = typeHist;
		this.dateHist = dateHist;
	}
	public String getTypeHist() {
		return typeHist;
	}
	public void setTypeHist(String typeHist) {
		this.typeHist = typeHist;
	}
	public Date getDateHist() {
		return dateHist;
	}
	public void setDateHist(Date dateHist) {
		this.dateHist = dateHist;
	}
	
	public Demande getDemande() {
		return demande;
	}
	public void setDemande(Demande demande) {
		this.demande = demande;
	}
    
}


