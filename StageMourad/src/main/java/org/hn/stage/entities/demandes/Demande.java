package org.hn.stage.entities.demandes;

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
import org.hn.stage.entities.typeDemandes.TypeDemande;
@Entity
@Table(name="demandes")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "dmd_clef")) })
public class Demande extends BaseEntity{

	private static final long serialVersionUID = -7663440790145065141L;
	@ManyToOne
    @Column(name="dmd_tyd_clef")
	@JoinColumn(name="tyd_clef")	
	private TypeDemande typeDemande;
	@OneToMany(mappedBy="dod_clef")
	private Collection<DocumentDemande> documentDemandes = new ArrayList<DocumentDemande>();
	@OneToMany(mappedBy="prd_clef")
   	private Collection<PrerequisDemade> prerequisDemades = new ArrayList<PrerequisDemade>();
	
	public TypeDemande getTypeDemande() {
		return typeDemande;
	}
	public void setTypeDemande(TypeDemande typeDemande) {
		this.typeDemande = typeDemande;
	}
	public Collection<DocumentDemande> getDocumentDemandes() {
		return documentDemandes;
	}
	public void setDocumentDemandes(Collection<DocumentDemande> documentDemandes) {
		this.documentDemandes = documentDemandes;
	}
	public Collection<PrerequisDemade> getPrerequisDemades() {
		return prerequisDemades;
	}
	public void setPrerequisDemades(Collection<PrerequisDemade> prerequisDemades) {
		this.prerequisDemades = prerequisDemades;
	}

}
*/