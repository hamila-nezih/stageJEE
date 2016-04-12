package org.hc.stage.entities.types.typesDeDemandes;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hc.stage.entities.base.BaseEntity;

@Entity
@Table(name="types_demandes")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "tyd_clef")) })
public class TypeDemande extends BaseEntity{
	
 
	private static final long serialVersionUID = -7082899346892779685L;
	
	@Column(name="tyd_libelle")
    private String libelle;
	
	@Column(name="tyd_actif")
	private Boolean actif;

	public TypeDemande() {
		super();
		
	}


	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}


	public TypeDemande(String libelle, Boolean actif) {
		super();
		this.libelle = libelle;
		this.actif = actif;
	}

	
	
}
