package org.hn.stage.entities.typeDemandes;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hn.stage.entities.base.BaseEntity;
import org.hn.stage.entities.demandes.PrerequisDemande;


@Entity
@Table(name="prerequis_Type_dmd")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "ptd_clef")) })
public class PrerequisTypeDemande extends BaseEntity{

	private static final long serialVersionUID = 7012500035049546462L;
	@ManyToOne
	@JoinColumn(name="ptd_tyd_clef",referencedColumnName="tyd_clef")
	private TypeDemande typeDemande;
	@OneToMany(mappedBy="id")
	private Collection<PrerequisDemande> prerequisDemades = new ArrayList<PrerequisDemande>();
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
	public Collection<PrerequisDemande> getPrerequisDemades() {
		return prerequisDemades;
	}
	public void setPrerequisDemades(Collection<PrerequisDemande> prerequisDemades) {
		this.prerequisDemades = prerequisDemades;
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
