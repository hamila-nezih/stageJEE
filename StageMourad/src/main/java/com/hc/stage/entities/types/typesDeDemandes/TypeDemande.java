package com.hc.stage.entities.types.typesDeDemandes;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.hc.stage.entities.base.BaseEntity;

/**
 * @author 
 *
 */
@Entity
@Table(name = "types_demandes")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "tyd_clef")) })
public class TypeDemande extends BaseEntity {
	private static final long serialVersionUID = -7082899346892779685L;

	@Column(name = "tyd_titre")
	private String titre;

	@Column(name = "tyd_libelle")
	private String libelle;

	@Column(name = "tyd_actif")
	private Boolean actif;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "typeDemande")
	private Set<PrerequisTypeDemande> prerequisTypeDemandes;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "typeDemande")
	private Set<DocumentTypeDemande> documentsTypeDemandes;

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

	public Set<PrerequisTypeDemande> getPrerequisTypeDemandes() {
		return prerequisTypeDemandes;
	}

	public void setPrerequisTypeDemandes(Set<PrerequisTypeDemande> prerequisTypeDemandes) {
		this.prerequisTypeDemandes = prerequisTypeDemandes;
	}

	public Set<DocumentTypeDemande> getDocumentsTypeDemandes() {
		return documentsTypeDemandes;
	}

	public void setDocumentsTypeDemandes(Set<DocumentTypeDemande> documentsTypeDemandes) {
		this.documentsTypeDemandes = documentsTypeDemandes;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public TypeDemande(String titre, String libelle, Boolean actif) {
		super();
		this.titre = titre;
		this.libelle = libelle;
		this.actif = actif;
	}

}
