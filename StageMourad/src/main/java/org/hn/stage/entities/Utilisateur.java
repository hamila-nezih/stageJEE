package org.hn.stage.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

import org.hn.stage.entities.base.BaseEntity;

@Entity
@Table(name="utilisateurs")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "utl_clef")) })
public class Utilisateur extends BaseEntity{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1551981328753707775L;

	
    @Column(name="utl_libelle")
    private String libelle;
    
   // @Column(name="srv_clef")
   // private Service service ;


	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


    
}

