package com.hc.stage.entities.historisation.historisationDesTypesDeDemandes;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hc.stage.entities.acteurs.Utilisateur;
import com.hc.stage.entities.base.BaseEntity;
import com.hc.stage.entities.types.typesDeDemandes.TypeDemande;
@Entity
@Table(name="historique_types_demandes")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "htd_clef")) })
public class HistoriqueTypeDemande extends BaseEntity{
	
	private static final long serialVersionUID = -7498047335889669355L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tyd_clef", nullable = false)
	private TypeDemande typeDemande;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uti_clef", nullable = false)
	private Utilisateur utilisateur;
	
	@Column(name = "htd_date")
	private Date dateHistorique;
	
	@Column(name = "htd_commentaire")
	private String commentaire;

	public TypeDemande getTypeDemande() {
		return typeDemande;
	}

	public void setTypeDemande(TypeDemande typeDemande) {
		this.typeDemande = typeDemande;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public HistoriqueTypeDemande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Date getDateHistorique() {
		return dateHistorique;
	}

	public void setDateHistorique(Date dateHistorique) {
		this.dateHistorique = dateHistorique;
	}
	

}
