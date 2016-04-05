package org.hn.stage.entitiesAll;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hn.stage.entities.Client;
@Entity
public class Demande implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idDmd;
	private Date dateDmd ;
	@ManyToOne
	@JoinColumn(name="idTraitement")
    private TraitementDmd traitementDmd ;
	public TraitementDmd getTraitementDmd() {
		return traitementDmd;
	}
	public void setTraitementDmd(TraitementDmd traitementDmd) {
		this.traitementDmd = traitementDmd;
	}
	@ManyToOne
	@JoinColumn(name="idOffre")
	private OffreEmploi idOffre ;
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client ;
	public Demande(Date dateDmd,Client client) {
		super();
		this.client =client ;
		this.dateDmd = dateDmd;
	}
	public Demande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OffreEmploi getIdOffre() {
		return idOffre;
	}
	public void setIdOffre(OffreEmploi idOffre) {
		this.idOffre = idOffre;
	}
	public Long getIdDmd() {
		return idDmd;
	}
	public void setIdDmd(Long idDmd) {
		this.idDmd = idDmd;
	}
	public Date getDateDmd() {
		return dateDmd;
	}
	public void setDateDmd(Date dateDmd) {
		this.dateDmd = dateDmd;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

}
