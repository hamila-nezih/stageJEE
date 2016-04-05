package org.hn.stage.entities.demandes;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/*
import org.hn.stage.entities.base.BaseEntity;
import org.hn.stage.entities.typeDemandes.PrerequisTypeDemande;


@Entity
@Table(name="prq_Type_dmd")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "prd_clef")) })
public class PrerequisDemade extends BaseEntity{

    
	private static final long serialVersionUID = 2332737171236259159L;

	@Column(name="prd_libelle")
    private String libelle;
    @ManyToOne
    @Column(name="prd_prq_clef")
	@JoinColumn(name="prq_clef")    
    private PrerequisTypeDemande prerequisTypeDemande ;
    @ManyToOne
    @Column(name="prd_dmd_clef")
	@JoinColumn(name="dmd_clef")    
    private Demande demande ;

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public PrerequisTypeDemande getPrerequisTypeDemande() {
		return prerequisTypeDemande;
	}

	public void setPrerequisTypeDemande(PrerequisTypeDemande prerequisTypeDemande) {
		this.prerequisTypeDemande = prerequisTypeDemande;
	}

	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}
    
    
}
*/
