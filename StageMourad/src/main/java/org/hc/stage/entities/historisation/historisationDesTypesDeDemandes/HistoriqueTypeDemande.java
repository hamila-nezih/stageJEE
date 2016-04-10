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

import org.hc.stage.entities.base.BaseEntity;
import org.hc.stage.entities.types.typesDeDemandes.TypeDemande;
@Entity
@Table(name="historique_types_demandes")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "htd_clef")) })
public class HistoriqueTypeDemande extends BaseEntity{
	
	private static final long serialVersionUID = -7498047335889669355L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tyd_clef", nullable = false)
	private TypeDemande typeDemande;
	
	@Column(name = "htd_date_modif")
	private Date dateModification;
	
	@Column(name = "htd_commentaire")
	private String commentaire;

	public TypeDemande getTypeDemande() {
		return typeDemande;
	}

	public void setTypeDemande(TypeDemande typeDemande) {
		this.typeDemande = typeDemande;
	}

	public Date getDateModification() {
		return dateModification;
	}

	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	

}
