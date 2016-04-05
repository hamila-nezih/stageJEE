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
import org.hn.stage.entities.demandes.DocumentDemande;

@Entity
@Table(name="Doc_type_dmd")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "dtd_clef")) })
public class DocumentTypeDemande extends BaseEntity{

	
	private static final long serialVersionUID = 6980861635976314154L;
	
    @Column(name="dtd_libelle")
    private String libelle;    
    @Column(name="dtd_obligatoire")
    private Boolean obligatoire; 
    @ManyToOne
    @Column(name="dtd_tyd_clef")
	@JoinColumn(name="tyd_clef")
    private TypeDemande typeDemande;
    @OneToMany(mappedBy="dod_clef")
   	private Collection<DocumentDemande> documentDemandes = new ArrayList<DocumentDemande>();

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

	public TypeDemande getTypeDemande() {
		return typeDemande;
	}

	public void setTypeDemande(TypeDemande typeDemande) {
		this.typeDemande = typeDemande;
	}
    
    
}

*/