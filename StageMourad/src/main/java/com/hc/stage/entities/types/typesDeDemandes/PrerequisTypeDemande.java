package com.hc.stage.entities.types.typesDeDemandes;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hc.stage.entities.base.BaseEntity;
import com.hc.stage.entities.demandes.PrerequisDeDemande;

@Entity
@Table(name = "types_prerequis")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "ptd_clef")) })
@JsonIgnoreProperties({ "typeDemande" })
public class PrerequisTypeDemande extends BaseEntity {

	private static final long serialVersionUID = 7012500035049546462L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tyd_clef", referencedColumnName = "tyd_clef")
	private TypeDemande typeDemande;

	@Column(name = "ptd_type_varibale")
	private String tybeVariable;
	
	@Column(name = "ptd_libelle")
	private String libelle;

	@Column(name = "ptd_ordre")
	private String ordre;

	
	@Column(name = "ptd_obligatoire")
	private Boolean obligatoire;

	public PrerequisTypeDemande(String libelle, Boolean obligatoire, TypeDemande typeDemande) {
		super();
		this.typeDemande = typeDemande;
		this.libelle = libelle;
		this.obligatoire = obligatoire;
	}

	public PrerequisTypeDemande() {
		super();
	}

	public TypeDemande getTypeDemande() {
		return typeDemande;
	}

	public void setTypeDemande(TypeDemande typeDemande) {
		this.typeDemande = typeDemande;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setObligatoire(Boolean obligatoire) {
		this.obligatoire = obligatoire;
	}

	public Boolean getObligatoire() {
		return obligatoire;
	}

	public void setOrdre(String ordre) {
		this.ordre = ordre;
	}

	public String getOrdre() {
		return ordre;
	}

	public String getTybeVariable() {
		return tybeVariable;
	}

	public void setTybeVariable(String tybeVariable) {
		this.tybeVariable = tybeVariable;
	}



}
