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
import org.hc.stage.entities.types.typesDeDemandes.TypeDemande;
@Entity
@Table(name="historique_typ_dmd")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "htd_clef")) })
public class HistoriqueTypeDemande extends BaseEntity{
	
	private static final long serialVersionUID = -7498047335889669355L;
	
	@Column(name = "htd_type_hist")
	private String typeHist;
	
	@Column(name = "htd_date")
	private Date dateHist;
	
	@Column(name = "htd_commentaire")
	private String commentaire;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "htd_res_clef", nullable = false)
	private Utilisateur utilisateur;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "htd_tyd_clef", nullable = false)
	private TypeDemande typeDemande;
	
	public HistoriqueTypeDemande(String typeHist, Date dateHist, String commentaire) {
		super();
		this.typeHist = typeHist;
		this.dateHist = dateHist;
		this.commentaire = commentaire;
	}
	
	public HistoriqueTypeDemande() {
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
	public TypeDemande getTypeDemande() {
		return typeDemande;
	}
	public void setTypeDemande(TypeDemande typeDemande) {
		this.typeDemande = typeDemande;
	}
	
	

}
