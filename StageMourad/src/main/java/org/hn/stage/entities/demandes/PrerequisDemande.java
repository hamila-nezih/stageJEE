package org.hn.stage.entities.demandes;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hn.stage.entities.base.BaseEntity;
import org.hn.stage.entities.typeDemandes.PrerequisTypeDemande;


@Entity
@Table(name="prerequis_dmd")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "prd_clef")) })
public class PrerequisDemande extends BaseEntity{

    
	private static final long serialVersionUID = 2332737171236259159L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prd_dmd_clef", nullable = false)
    private Demande demande ;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prd_prq_clef", nullable = false)
    private PrerequisTypeDemande prerequisTypeDemande ;
	@Column(name="prd_libelle")
    private String libelle;

	public PrerequisDemande(String libelle) {
		super();
		this.libelle = libelle;
	}

	public PrerequisDemande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

	public PrerequisTypeDemande getPrerequisTypeDemande() {
		return prerequisTypeDemande;
	}

	public void setPrerequisTypeDemande(PrerequisTypeDemande prerequisTypeDemande) {
		this.prerequisTypeDemande = prerequisTypeDemande;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	
    
	


    
}

