package org.hn.stage.entitiesAll;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="CreationOffres")
public class CreationOffre implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)	
	private Long idCreOff ;
	@ManyToOne
	@JoinColumn(name="idOffre")
	private OffreEmploi idOffre ;
	private Date dateCreation ;
	@ManyToOne
	@JoinColumn(name="idSec")
	private Secretariat secretariat ;
	

	public CreationOffre(Date dateCreation) {
		super();
		this.dateCreation = dateCreation;
	}


	public Long getIdOff() {
		return idCreOff;
	}


	public void setIdOff(Long idCreOff) {
		this.idCreOff = idCreOff;
	}


	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	public Secretariat getSecretariat() {
		return secretariat;
	}


	public void setSecretariat(Secretariat secretariat) {
		this.secretariat = secretariat;
	}


	public CreationOffre() {
		// TODO Auto-generated constructor stub
	}

}
