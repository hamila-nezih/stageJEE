package org.hn.stage.entities.typeDemandes;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hn.stage.entities.Service;
import org.hn.stage.entities.base.BaseEntity;
import org.hn.stage.entities.demandes.Demande;


@Entity
@Table(name="type_demandes")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "tyd_clef")) })
public class TypeDemande extends BaseEntity{
	
 
	private static final long serialVersionUID = -7082899346892779685L;
	
	@OneToMany(mappedBy="id")
	private Collection<Demande> demandes = new ArrayList<Demande>();
	@OneToMany(mappedBy="id")
   	private Collection<DocumentTypeDemande> documentTypeDemandes = new ArrayList<DocumentTypeDemande>();
    @OneToMany(mappedBy="id")
   	private Collection<PrerequisTypeDemande> prerequisTypeDemandes = new ArrayList<PrerequisTypeDemande>();
	@Column(name="tyd_libelle")
    private String libelle;    
    @Column(name="tyd_srv_clef")
    private Service service;
	public TypeDemande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Collection<Demande> getDemandes() {
		return demandes;
	}

	public void setDemandes(Collection<Demande> demandes) {
		this.demandes = demandes;
	}

	public Collection<DocumentTypeDemande> getDocumentTypeDemandes() {
		return documentTypeDemandes;
	}

	public void setDocumentTypeDemandes(Collection<DocumentTypeDemande> documentTypeDemandes) {
		this.documentTypeDemandes = documentTypeDemandes;
	}

	public Collection<PrerequisTypeDemande> getPrerequisTypeDemandes() {
		return prerequisTypeDemandes;
	}

	public void setPrerequisTypeDemandes(Collection<PrerequisTypeDemande> prerequisTypeDemandes) {
		this.prerequisTypeDemandes = prerequisTypeDemandes;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}   
	
}
