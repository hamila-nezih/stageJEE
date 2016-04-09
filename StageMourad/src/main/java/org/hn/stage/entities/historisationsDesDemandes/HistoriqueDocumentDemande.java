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

import org.hn.stage.entities.acteurs.Client;
import org.hn.stage.entities.base.BaseEntity;
import org.hn.stage.entities.demandes.DocumentDemande;


@Entity
@Table(name="historique_doc_demande")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "hdd_clef")) })
public class HistoriqueDocumentDemande extends BaseEntity {
	
	private static final long serialVersionUID = -8090461535242541173L;
	
	
	@Column(name = "hdd_type_hist")
	private String typeHist;
	@Column(name = "hdd_date")
	private Date dateHist;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hdd_cli_clef", nullable = false)	
	private Client  client;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hdd_dod_clef", nullable = false)	
	private DocumentDemande documentDemande;
	
	public HistoriqueDocumentDemande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HistoriqueDocumentDemande(String typeHist, Date date) {
		this.typeHist = typeHist;
		this.dateHist = date;
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
	public DocumentDemande getDocumentDemande() {
		return documentDemande;
	}
	public void setDocumentDemande(DocumentDemande documentDemande) {
		this.documentDemande = documentDemande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
