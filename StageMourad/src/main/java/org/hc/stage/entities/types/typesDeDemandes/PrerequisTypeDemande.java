package org.hc.stage.entities.types.typesDeDemandes;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hc.stage.entities.base.BaseEntity;


@Entity
@Table(name="types_prerequis")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "ptd_clef")) })
public class PrerequisTypeDemande extends BaseEntity{

	private static final long serialVersionUID = 7012500035049546462L;
	@ManyToOne
	@JoinColumn(name="tyd_clef",referencedColumnName="tyd_clef")
	private TypeDemande typeDemande;

	@Column(name="ptd_libelle")
    private String libelle;
	
    @Column(name="ptd_obligatoire")
    private Boolean obligatoire;

    public PrerequisTypeDemande(String libelle,Boolean obligatoire, TypeDemande typeDemande) {
		super();
		this.typeDemande = typeDemande ;
		this.libelle = libelle;
		this.obligatoire = obligatoire;
	}
	public PrerequisTypeDemande() {
		super();
		// TODO Auto-generated constructor stub
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
    
}
