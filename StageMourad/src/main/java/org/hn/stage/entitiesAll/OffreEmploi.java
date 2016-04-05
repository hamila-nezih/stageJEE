package org.hn.stage.entitiesAll;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class OffreEmploi implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idOffre ;
	
	public Long getIdOffre() {
		return idOffre;
	}

	public void setIdOffre(Long idOffre) {
		this.idOffre = idOffre;
	}

	public String getTypePost() {
		return TypePost;
	}

	public void setTypePost(String typePost) {
		TypePost = typePost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Collection<Demande> getDemandes() {
		return demandes;
	}

	public void setDemandes(Collection<Demande> demandes) {
		this.demandes = demandes;
	}

	private String TypePost ;
	private String description ;
	private Date dateDebut ;
	private Date dateFin ;
	@ManyToOne
	@JoinColumn(name="idCreOff")
	private CreationOffre CreationOffre ;
	@OneToMany(mappedBy="idOffre")
    private Collection<Demande> demandes = new ArrayList<Demande>();

	public OffreEmploi() {
		// TODO Auto-generated constructor stub
	}

}
