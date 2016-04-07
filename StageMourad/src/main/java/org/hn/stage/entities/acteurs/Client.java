package org.hn.stage.entities.acteurs;

import java.util.*;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.hn.stage.entities.base.BaseEntity;

@Entity
@Table(name="clients")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "cli_clef")) })
public class Client extends BaseEntity{

	private static final long serialVersionUID = 1235750709613679666L;
	
	@Column(name = "cli_nom")
	private String nom ;
	@Column(name = "cli_prenom")
	private String prenom ;
	@Column(name = "cli_date_naissance")
	private Date dateNaissance;
	@Column(name = "cli_mail")
	private String mail ;
	@NotEmpty
	@Column(name = "cli_login")
	private String login ;
	@NotEmpty
	@Column(name = "cli_mots_passe")
	private String motsPasse ;

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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotPass() {
		return motsPasse;
	}
	public void setMotPass(String motPass) {
		this.motsPasse = motPass;
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
	
	public Client(String nom, String prenom, Date dateNaissance, String mail, String login, String motPass) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.mail = mail;
		this.login = login;
		this.motsPasse = motPass;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
