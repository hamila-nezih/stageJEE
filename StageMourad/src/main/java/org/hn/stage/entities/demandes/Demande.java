package org.hn.stage.entities.demandes;






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

	
	private static final long serialVersionUID = 1023047869904794715L;

	@ManyToOne
    @JoinColumn(name="dmd_tyd_clef",referencedColumnName="tyd_clef")	
	private TypeDemande typeDemande;
	@OneToMany(mappedBy="id")
	private Collection<DocumentDemande> documentDemandes = new ArrayList<DocumentDemande>();
	@OneToMany(mappedBy="id")
	private Collection<PrerequisDemade> prerequisDemades = new ArrayList<PrerequisDemade>();
	
	public Demande() {
		super();
		// TODO Auto-generated constructor stub
	}
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
