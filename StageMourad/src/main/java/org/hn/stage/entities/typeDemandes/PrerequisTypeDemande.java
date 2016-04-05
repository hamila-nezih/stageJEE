package org.hn.stage.entities.typeDemandes;
/*
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
import org.hn.stage.entities.demandes.PrerequisDemade;


@Entity
@Table(name="prq_Type_dmd")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "prq_clef")) })
public class PrerequisTypeDemande extends BaseEntity{

	
	private static final long serialVersionUID = 7012500035049546462L;

	@Column(name="prq_libelle")
    private String libelle;
    
    @Column(name="prq_type_data")
    private String typeData ;
    
    @Column(name="prq_obligatoire")
    private Boolean obligatoire;
    
    
    @ManyToOne
    @Column(name="prq_tyd_clef")
	@JoinColumn(name="tyd_clef")	
    private TypeDemande typeDemande ;
    @OneToMany(mappedBy="prd_clef")
   	private Collection<PrerequisDemade> prerequisDemades = new ArrayList<PrerequisDemade>();
	
	
	public String getTypeData() {
		return typeData;
	}

	public void setTypeData(String typeData) {
		this.typeData = typeData;
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

	public Collection<PrerequisDemade> getPrerequisDemades() {
		return prerequisDemades;
	}

	public void setPrerequisDemades(Collection<PrerequisDemade> prerequisDemades) {
		this.prerequisDemades = prerequisDemades;
	}
    
    
}

*/