package com.hc.stage.metier.utilisateur;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.hc.stage.dao.acteurs.InterfaceDaoUtilisateur;
import com.hc.stage.dao.historiqueDesTypesDeDemandes.InterfaceDaoHistoriqueTypeDemande;
import com.hc.stage.dao.typeDemandes.InterfaceDaoDocumentTypeDemande;
import com.hc.stage.dao.typeDemandes.InterfaceDaoPrerequisTypeDemande;
import com.hc.stage.dao.typeDemandes.InterfaceDaoTypDemande;
import com.hc.stage.entities.acteurs.Utilisateur;
import com.hc.stage.entities.historisation.historisationDesTypesDeDemandes.HistoriqueTypeDemande;
import com.hc.stage.entities.types.typesDeDemandes.DocumentTypeDemande;
import com.hc.stage.entities.types.typesDeDemandes.PrerequisTypeDemande;
import com.hc.stage.entities.types.typesDeDemandes.TypeDemande;

@Transactional
public class ImpIntMetierUtilisateur implements InterfaceMetierUtilisateur {

	private InterfaceDaoUtilisateur daoUtilisateur;
	private InterfaceDaoTypDemande daoTypDemande;

	private InterfaceDaoDocumentTypeDemande daoDocumentTypeDemande;
	private InterfaceDaoPrerequisTypeDemande daoPrerequisTypeDemande;
	private InterfaceDaoHistoriqueTypeDemande daoHistoriqueTypeDemande;

	public List<PrerequisTypeDemande> getTypePrerequisD(Long id) {

		return daoPrerequisTypeDemande.getPrerequisTypeDemande(id);
	}

	public void setDaoUtilisateur(InterfaceDaoUtilisateur daoUtilisateur) {
		this.daoUtilisateur = daoUtilisateur;
	}

	public void setDaoTypDemande(InterfaceDaoTypDemande daoTypDemande) {
		this.daoTypDemande = daoTypDemande;
	}

	public void setDaoDocumentTypeDemande(InterfaceDaoDocumentTypeDemande daoDocumentTypeDemande) {
		this.daoDocumentTypeDemande = daoDocumentTypeDemande;
	}

	public void setDaoPrerequisTypeDemande(InterfaceDaoPrerequisTypeDemande daoPrerequisTypeDemande) {
		this.daoPrerequisTypeDemande = daoPrerequisTypeDemande;
	}

	public void setDaoHistoriqueTypeDemande(InterfaceDaoHistoriqueTypeDemande daoHistoriqueTypeDemande) {
		this.daoHistoriqueTypeDemande = daoHistoriqueTypeDemande;
	}

	public Long ajouterNouveauTypeDemande(TypeDemande tyD, Utilisateur utilisateur) {

		Long idTyD = daoTypDemande.ajouter(tyD).getId();
		tyD.setId(idTyD);
		HistoriqueTypeDemande historiqueTypeDemande = new HistoriqueTypeDemande();
		historiqueTypeDemande.setCommentaire("premier ajout ");
		historiqueTypeDemande.setTypeDemande(tyD);
		historiqueTypeDemande.setUtilisateur(utilisateur);
		daoHistoriqueTypeDemande.ajouter(historiqueTypeDemande);
		return idTyD;
	}

	public Long AjouterNouveauTypeDocumentDemande(DocumentTypeDemande dTD, Utilisateur utilisateur) {

		Long idTyDoc = daoDocumentTypeDemande.ajouter(dTD).getId();
		dTD.setId(idTyDoc);
		return idTyDoc;
	}

	public Long AjouterNouveauTypePrerequis(PrerequisTypeDemande pTD, Utilisateur utilisateur) {

		Long idTyP = daoPrerequisTypeDemande.ajouter(pTD).getId();
		pTD.setId(idTyP);
		return idTyP;
	}

	public Long ajouterNouvelUtilisateur(Utilisateur uti) {
		return daoUtilisateur.ajouter(uti).getId();
	}

	public List<Utilisateur> getTousUtl() {

		return daoUtilisateur.select();

	}

	@Override
	public Utilisateur getUtilisateur(Long id) {

		return daoUtilisateur.findById(id);
	}

	@Override
	public void supprimierUtl(Long id) {

		Utilisateur utilisateur = daoUtilisateur.findById(id);
		daoUtilisateur.delete(utilisateur);
		;

	}

	@Override
	public Utilisateur upDateUtl(Long id, String libelle, String nom, String prenom) {

		Utilisateur utilisateur = daoUtilisateur.findById(id);
		utilisateur.setLibelle(libelle);
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		return daoUtilisateur.update(utilisateur);
	}

	@Override
	public TypeDemande creerNouveauTypeDemande(TypeDemande typeDemande) {
		System.out.println(typeDemande.getTitre());
		TypeDemande typeDemande2 = daoTypDemande.ajouter(typeDemande);
		HistoriqueTypeDemande historiqueTypeDemande = new HistoriqueTypeDemande();
		historiqueTypeDemande.setTypeDemande(typeDemande2);
		historiqueTypeDemande.setCommentaire("creation");
		Date d = new Date();
		historiqueTypeDemande.setDateHistorique(d);
	    daoHistoriqueTypeDemande.ajouter(historiqueTypeDemande);
		return typeDemande2;
	}

	@Override
	public void creerNouveauTypePrerequisDemande(PrerequisTypeDemande prerequisTypeDemande) {
		daoPrerequisTypeDemande.ajouter(prerequisTypeDemande);
	}

	@Override
	public void creerNouveauTypeDocumentDemande(DocumentTypeDemande documentTypeDemande) {
		daoDocumentTypeDemande.ajouter(documentTypeDemande);
	}

	@Override
	public TypeDemande getTypeDemande(Long id) {
		return daoTypDemande.findById(id);

	}

	@Override
	public List<HistoriqueTypeDemande> getAllHistoriqueTypeDemande() {
		
		return daoHistoriqueTypeDemande.getAllHistoriqueTypeDemande();
	}

	

}
