package org.hn.stage.entities.historisationsTypes;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hn.stage.entities.Responsable;
import org.hn.stage.entities.base.BaseEntity;
import org.hn.stage.entities.typeDemandes.DocumentTypeDemande;

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
	private Responsable responsable;
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
	public Responsable getResponsable() {
		return responsable;
	}
	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}
	public DocumentTypeDemande getDocumentTypeDemande() {
		return documentTypeDemande;
	}
	public void setDocumentTypeDemande(DocumentTypeDemande documentTypeDemande) {
		this.documentTypeDemande = documentTypeDemande;
	}

}
