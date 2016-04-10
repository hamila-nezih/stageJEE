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
import org.hc.stage.entities.demandes.PrerequisDeDemande;

@Entity
@Table(name="historique_prq")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "hpd_clef")) })
public class HistoriquePrerequisDemande extends BaseEntity {
	
	private static final long serialVersionUID = -3970526048311749802L;
	
	
	@Column(name = "hpd_type_hist")
	private String typeHist;
	@Column(name = "hpd_date")
	private Date dateHist;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hpd_cli_clef", nullable = false)	
	private Client  client;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hpd_prd_clef", nullable = false)	
	private PrerequisDeDemande prerequisDemande;
	
	public HistoriquePrerequisDemande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public HistoriquePrerequisDemande(String typeHist, Date dateHist) {
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
	public PrerequisDeDemande getPrerequisDemande() {
		return prerequisDemande;
	}
	public void setPrerequisDemande(PrerequisDeDemande prerequisDemande) {
		this.prerequisDemande = prerequisDemande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
