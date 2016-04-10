package org.hc.stage.entities.historisation.historisationDesDemandes;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hc.stage.entities.acteurs.Client;
import org.hc.stage.entities.base.BaseEntity;
import org.hc.stage.entities.demandes.Demande;

@Entity
@Table(name="historique_demandes")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "hdm_clef")) })
public class HistoriqueDemande extends BaseEntity{

	public HistoriqueDemande() {
		super();
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = -7993255878282588813L;
	@Column(name="hdm_type_hist")
	private String typeHist;
	@Column(name="hdm_date")
	private Date dateHist;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hdm_cli_clef", nullable = false)	
	private Client  client;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hdm_dmd_clef", nullable = false)	
	private Demande demande;
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
	public Client  getClient() {
		return client;
	}
	public void setClient(Client  client) {
		this.client = client;
	}
	public Demande getDemande() {
		return demande;
	}
	public void setDemande(Demande demande) {
		this.demande = demande;
	}
    
}


