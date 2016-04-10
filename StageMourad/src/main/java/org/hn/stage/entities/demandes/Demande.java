package org.hn.stage.entities.demandes;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hn.stage.entities.base.BaseEntity;
import org.hn.stage.entities.typeDemandes.TypeDemande;

@Entity
@Table(name="demandes")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "dmd_clef")) })
public class Demande extends BaseEntity{

	
	private static final long serialVersionUID = 1023047869904794715L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dmd_tyd_clef", nullable = false)	
	private TypeDemande typeDemande;	
	public Demande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void setTypeDemande(TypeDemande typeDemande) {
		this.typeDemande = typeDemande;
	}
	public TypeDemande getTypeDemande() {
		return typeDemande;
	}

	
	
	

}
