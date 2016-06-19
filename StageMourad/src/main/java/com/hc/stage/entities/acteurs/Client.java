package com.hc.stage.entities.acteurs;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.hc.stage.entities.base.BaseEntity;

@Entity
@Table(name = "clients")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "cli_clef")) })
public class Client extends BaseEntity {

	private static final long serialVersionUID = 1235750709613679666L;

	@Column(name = "cli_nom")
	private String nom;
	@Column(name = "cli_prenom")
	private String prenom;
	@Column(name = "cli_date_naissance")
	private Date dateNaissance;
	@Column(name = "cli_sex")
	private String sex;	
	@Column(name = "cli_tel")
	private String tel;
	@Column(name = "cli_mail")
	private String mail;
	@NotEmpty
	@Column(name = "cli_mots_passe")
	private String motsPasse;

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Client() {
		super();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMotsPasse() {
		return motsPasse;
	}

	public void setMotsPasse(String motsPasse) {
		this.motsPasse = motsPasse;
	}

	public Client(String nom, String prenom, Date dateNaissance, String sex, String tel, String mail,
			String motsPasse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.sex = sex;
		this.tel = tel;
		this.mail = mail;
		this.motsPasse = motsPasse;
	}

}
