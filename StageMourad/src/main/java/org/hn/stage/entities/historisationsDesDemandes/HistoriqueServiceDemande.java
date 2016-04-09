package org.hn.stage.entities.historisationsDesDemandes;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hn.stage.entities.acteurs.Utilisateur;
import org.hn.stage.entities.base.BaseEntity;
import org.hn.stage.entities.demandes.Demande;

@Entity
@Table(name="historique_ser_dmd")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "hsd_clef")) })
public class HistoriqueServiceDemande extends BaseEntity{

	public HistoriqueServiceDemande() {
		super();
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = -5066946268928237812L;
	@Column(name = "hsd_type_hist")
	private String typeHist;
	@Column(name = "hsd_date")
	private Date dateHist;
	@Column(name = "hsd_commentaire")
	private String commentaire;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hsd_svc_clef", nullable = false)	
	private Utilisateur service ;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hsd_dmd_clef", nullable = false)	
	private Demande demande ;
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
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Utilisateur getService() {
		return service;
	}
	public void setService(Utilisateur service) {
		this.service = service;
	}
	public Demande getDemande() {
		return demande;
	}
	public void setDemande(Demande demande) {
		this.demande = demande;
	}
}
