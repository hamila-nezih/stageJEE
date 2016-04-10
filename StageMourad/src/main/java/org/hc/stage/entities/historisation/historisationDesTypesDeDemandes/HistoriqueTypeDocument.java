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
import org.hc.stage.entities.types.typesDeDemandes.DocumentTypeDemande;

@Entity
@Table(name="historique_typ_doc")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "htdoc_clef")) })
public class HistoriqueTypeDocument extends BaseEntity{
	
	private static final long serialVersionUID = 5490262890186626008L;
	
	
	@Column(name = "htdoc_type_hist")
	private String typeHist;
	@Column(name = "htdoc_date")
	private Date dateHist;
	@Column(name = "htdoc_commentaire")
	private String commentaire;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "htdoc_res_clef", nullable = false)
	private Utilisateur utilisateur;
	public HistoriqueTypeDocument(String typeHist, Date dateHist, String commentaire) {
		super();
		this.typeHist = typeHist;
		this.dateHist = dateHist;
		this.commentaire = commentaire;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "htdoc_dtd_clef", nullable = false)
	private DocumentTypeDemande documentTypeDemande;
	
	public HistoriqueTypeDocument() {
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
	public DocumentTypeDemande getDocumentTypeDemande() {
		return documentTypeDemande;
	}
	public void setDocumentTypeDemande(DocumentTypeDemande documentTypeDemande) {
		this.documentTypeDemande = documentTypeDemande;
	}

}
