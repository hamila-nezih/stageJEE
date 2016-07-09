package com.hc.stage.entities.types.typesDeDemandes;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hc.stage.entities.base.BaseEntity;

@Entity
@Table(name = "types_documents")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "dtd_clef")) })
@JsonIgnoreProperties({"typeDemande"})
public class DocumentTypeDemande extends BaseEntity {

	private static final long serialVersionUID = 6980861635976314154L;

	@ManyToOne
	@JoinColumn(name = "tyd_clef", referencedColumnName = "tyd_clef")
	private TypeDemande typeDemande;

	@Column(name="tyd_ordre")
    private String ordre;
	
	
	@Column(name = "dtd_libelle")
	private String libelle;

	@Column(name = "dtd_obligatoire")
	private Boolean obligatoire;

	public DocumentTypeDemande(String libelle, Boolean obligatoire, TypeDemande typeDemande) {
		super();
		this.typeDemande = typeDemande;
		this.libelle = libelle;
		this.obligatoire = obligatoire;
	}

	public DocumentTypeDemande() {
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

	public Boolean getObligatoire() {
		return obligatoire;
	}

	public void setObligatoire(Boolean obligatoire) {
		this.obligatoire = obligatoire;
	}

	
	public DocumentTypeDemande(String libelle, Boolean obligatoire) {
		super();
		this.libelle = libelle;
		this.obligatoire = obligatoire;
	}

	public String getOrdre() {
		return ordre;
	}

	public void setOrdre(String ordre) {
		this.ordre = ordre;
	}
}
