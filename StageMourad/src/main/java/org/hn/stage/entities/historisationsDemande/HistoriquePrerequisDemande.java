package org.hn.stage.entities.historisationsDemande;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hn.stage.entities.Client;
import org.hn.stage.entities.base.BaseEntity;
import org.hn.stage.entities.demandes.PrerequisDemande;

@Entity
@Table(name="historique_prq")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "hdc_clef")) })
public class HistoriquePrerequisDemande extends BaseEntity {
	
	private static final long serialVersionUID = -3970526048311749802L;
	
	
	@Column(name = "hdc_type_hist")
	private String typeHist;
	@Column(name = "hdc_date")
	private Date dateHist;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hdc_cli_clef", nullable = false)	
	private Client  client;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hdm_prd_clef", nullable = false)	
	private PrerequisDemande prerequisDemande;
	
	public HistoriquePrerequisDemande() {
		super();
		// TODO Auto-generated constructor stub
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
	public PrerequisDemande getPrerequisDemande() {
		return prerequisDemande;
	}
	public void setPrerequisDemande(PrerequisDemande prerequisDemande) {
		this.prerequisDemande = prerequisDemande;
	}
}
