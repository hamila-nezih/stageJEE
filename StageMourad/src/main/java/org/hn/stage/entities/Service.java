package org.hn.stage.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hn.stage.entities.base.BaseEntity;


@Entity
@Table(name="services")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "srv_clef")) })
public class Service extends BaseEntity{

	
    /**
	 * 
	 */
	private static final long serialVersionUID = -1781951653776269042L;
	@Column(name="srv_libelle")
    private String libelle;



	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
    
    
}

