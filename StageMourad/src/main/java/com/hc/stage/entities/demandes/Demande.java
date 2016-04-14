package com.hc.stage.entities.demandes;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hc.stage.entities.acteurs.Client;
import com.hc.stage.entities.base.BaseEntity;
import com.hc.stage.entities.types.typesDeDemandes.TypeDemande;

@Entity
@Table(name="demandes")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "dmd_clef")) })
public class Demande extends BaseEntity{

	
	private static final long serialVersionUID = 1023047869904794715L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tyd_clef", nullable = false)	
	private TypeDemande typeDemande;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cli_clef", nullable = false)	
	private Client client;
	
	@Column(name="dmd_commentaire")
	private String commentaire;
	
	@Column(name="dmd_etat")
	private String etat; // en cours , en attente... // lien vers etape workflow
	
	@Column(name="dmd_date_creation")
	private Date dateCreation;
	
	@Column(name="dmd_date_modification")
	private Date dateModification;
	
	// sous-demandes... en cas de plusieurs sous-demandes...
	
	
	public Demande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void setTypeDemande(TypeDemande typeDemande) {
		this.typeDemande = typeDemande;
	}
	
	public TypeDemande getTypeDemande() {
		return typeDemande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateModification() {
		return dateModification;
	}

	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}

}
