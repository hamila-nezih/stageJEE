package com.hc.stage.entities.upload;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.hc.stage.entities.base.BaseEntity;

@Entity
@Table(name="upload")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "upload_clef")) })
public class upload extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -606240146830956140L;
	
	 @Column(name="nom_fichier")
	    private String nomFichier ;

	@Column(name="photo",columnDefinition = "LONGBLOB")
	private byte [] photo ;

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	

	public upload() {
		super();
		
	}

	public String getNomFichier() {
		return nomFichier;
	}

	public void setNomFichier(String nomFichier) {
		this.nomFichier = nomFichier;
	}

	public upload(String nomFichier, byte[] photo) {
		super();
		this.nomFichier = nomFichier;
		this.photo = photo;
	} 

	
}
