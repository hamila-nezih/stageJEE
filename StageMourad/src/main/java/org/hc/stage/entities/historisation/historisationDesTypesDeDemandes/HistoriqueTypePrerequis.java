package org.hc.stage.entities.historisation.historisationDesTypesDeDemandes;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hc.stage.entities.acteurs.Utilisateur;
import org.hc.stage.entities.base.BaseEntity;
import org.hc.stage.entities.types.typesDeDemandes.PrerequisTypeDemande;

@Entity
@Table(name="historique_typ_pre")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "htp_clef")) })
public class HistoriqueTypePrerequis extends BaseEntity{


	private static final long serialVersionUID = -8471639229760708841L;
	
	@Column(name = "htp_type_hist")
	private String typeHist;
	@Column(name = "htp_date")
	private Date dateHist;
	@Column(name = "htp_commentaire")
	private String commentaire;
	
	public HistoriqueTypePrerequis() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HistoriqueTypePrerequis(String typeHist, Date dateHist, String commentaire) {
		super();
		this.typeHist = typeHist;
		this.dateHist = dateHist;
		this.commentaire = commentaire;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "htp_res_clef", nullable = false)
	private Utilisateur utilisateur;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "htp_ptd_clef", nullable = false)
	private PrerequisTypeDemande prerequisTypeDemande;
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
	public Utilisateur getResponsable() {
		return utilisateur;
	}
	public void setResponsable(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public PrerequisTypeDemande getPrerequisTypeDemande() {
		return prerequisTypeDemande;
	}
	public void setPrerequisTypeDemande(PrerequisTypeDemande prerequisTypeDemande) {
		this.prerequisTypeDemande = prerequisTypeDemande;
	}


}
