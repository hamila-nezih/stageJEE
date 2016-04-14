package com.hc.stage.entities.historisation.historisationDesDemandes;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hc.stage.entities.base.BaseEntity;
import com.hc.stage.entities.types.typesDeDemandes.PrerequisTypeDemande;

@Entity
@Table(name="historique_prq_demandes")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "hpd_clef")) })
public class HistoriquePrerequisDemande extends BaseEntity {
	
	private static final long serialVersionUID = -3970526048311749802L;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hdm_clef", nullable = false)	
	private HistoriqueDemande  historiqueDemande;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ptd_clef", nullable = false)	
	private PrerequisTypeDemande prerequisTypeDemande;
		
	@Column(name="prd_contenue")   
    private String contenue ;

	public HistoriquePrerequisDemande(HistoriqueDemande historiqueDemande, PrerequisTypeDemande prerequisTypeDemande,
			String contenue) {
		super();
		this.historiqueDemande = historiqueDemande;
		this.prerequisTypeDemande = prerequisTypeDemande;
		this.contenue = contenue;
	}

	public HistoriquePrerequisDemande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HistoriqueDemande getHistoriqueDemande() {
		return historiqueDemande;
	}

	public void setHistoriqueDemande(HistoriqueDemande historiqueDemande) {
		this.historiqueDemande = historiqueDemande;
	}

	public PrerequisTypeDemande getPrerequisTypeDemande() {
		return prerequisTypeDemande;
	}

	public void setPrerequisTypeDemande(PrerequisTypeDemande prerequisTypeDemande) {
		this.prerequisTypeDemande = prerequisTypeDemande;
	}

	public String getContenue() {
		return contenue;
	}

	public void setContenue(String contenue) {
		this.contenue = contenue;
	}
	
	 
	
	
}
