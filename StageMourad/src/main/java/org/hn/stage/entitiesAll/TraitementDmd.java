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
@Table(name="Traitements")
public class TraitementDmd implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idTraitement ;
	@ManyToOne
	@JoinColumn(name="idDmd")
    private Demande demande ;
	@ManyToOne
	@JoinColumn(name="idSec")
	private Secretariat secretariat ;
	@ManyToOne
	@JoinColumn(name="idDir")
	private Directeur directeur ;
	private String avisSec ;
	private Date dateTrSec ;
	private boolean avisDir ;
	private Date dateTrDir ;

	public TraitementDmd(String avisSec, Date dateTrSec, boolean avisDir, Date dateTrDir) {
		super();
		this.avisSec = avisSec;
		this.dateTrSec = dateTrSec;
		this.avisDir = avisDir;
		this.dateTrDir = dateTrDir;
	}



	public Long getIdTraitement() {
		return idTraitement;
	}



	public void setIdTraitement(Long idTraitement) {
		this.idTraitement = idTraitement;
	}



	public Demande getDemande() {
		return demande;
	}



	public void setDemande(Demande demande) {
		this.demande = demande;
	}



	public String getAvisSec() {
		return avisSec;
	}



	public void setAvisSec(String avisSec) {
		this.avisSec = avisSec;
	}



	public Date getDateTrSec() {
		return dateTrSec;
	}



	public void setDateTrSec(Date dateTrSec) {
		this.dateTrSec = dateTrSec;
	}



	public boolean isAvisDir() {
		return avisDir;
	}



	public void setAvisDir(boolean avisDir) {
		this.avisDir = avisDir;
	}



	public Date getDateTrDir() {
		return dateTrDir;
	}



	public void setDateTrDir(Date dateTrDir) {
		this.dateTrDir = dateTrDir;
	}
	public TraitementDmd() {
	}

}
