package com.hc.stage.metier.upload;

import org.springframework.transaction.annotation.Transactional;

import com.hc.stage.dao.upload.InterfaceDaoUpload;
import com.hc.stage.entities.upload.upload;

@Transactional
public class ImpIntMetierUpload implements InterfaceMetierUpload {

	private InterfaceDaoUpload daoUpload;
	
	public void setDaoUpload(InterfaceDaoUpload daoUpload) {
		 this.daoUpload = daoUpload;
		 }

	@Override
	public Long ajouterNouvelleFichier(upload up) {
		daoUpload.ajouter(up);
		return null;
	}

	// private InterfaceDaoUtilisateur daoUtilisateur;
	// private InterfaceDaoTypDemande daoTypDemande;
	// private InterfaceDaoDocumentTypeDemande daoDocumentTypeDemande;
	// private InterfaceDaoPrerequisTypeDemande daoPrerequisTypeDemande;
	// private InterfaceDaoHistoriqueTypeDemande daoHistoriqueTypeDemande;
	//
	// public List<PrerequisTypeDemande>getTypePrerequisD(Long id){
	//
	// return daoPrerequisTypeDemande.getPrerequisTypeDemande(id);
	// }
	//
	// public void setDaoUtilisateur(InterfaceDaoUtilisateur daoUtilisateur) {
	// this.daoUtilisateur = daoUtilisateur;
	// }
	//
	// public void setDaoTypDemande(InterfaceDaoTypDemande daoTypDemande) {
	// this.daoTypDemande = daoTypDemande;
	// }
	//
	// public void setDaoDocumentTypeDemande(InterfaceDaoDocumentTypeDemande
	// daoDocumentTypeDemande) {
	// this.daoDocumentTypeDemande = daoDocumentTypeDemande;
	// }
	//
	// public void setDaoPrerequisTypeDemande(InterfaceDaoPrerequisTypeDemande
	// daoPrerequisTypeDemande) {
	// this.daoPrerequisTypeDemande = daoPrerequisTypeDemande;
	// }
	//
	// public void setDaoHistoriqueTypeDemande(InterfaceDaoHistoriqueTypeDemande
	// daoHistoriqueTypeDemande) {
	// this.daoHistoriqueTypeDemande = daoHistoriqueTypeDemande;
	// }
	//
	// public Long ajouterNouveauTypeDemande(TypeDemande tyD,Utilisateur
	// utilisateur){
	//
	// Long idTyD = daoTypDemande.ajouter(tyD).getId();
	// tyD.setId(idTyD);
	// HistoriqueTypeDemande historiqueTypeDemande = new
	// HistoriqueTypeDemande();
	// historiqueTypeDemande.setCommentaire("premier ajout ");
	// historiqueTypeDemande.setTypeDemande(tyD);
	// historiqueTypeDemande.setUtilisateur(utilisateur);
	// daoHistoriqueTypeDemande.ajouter(historiqueTypeDemande);
	// return idTyD ;
	// }
	//
	// public Long AjouterNouveauTypeDocumentDemande(DocumentTypeDemande dTD,
	// Utilisateur utilisateur){
	//
	// Long idTyDoc = daoDocumentTypeDemande.ajouter(dTD).getId();
	// dTD.setId(idTyDoc);
	// return idTyDoc ;
	// }
	//
	// public Long AjouterNouveauTypePrerequis(PrerequisTypeDemande pTD,
	// Utilisateur utilisateur){
	//
	// Long idTyP = daoPrerequisTypeDemande.ajouter(pTD).getId();
	// pTD.setId(idTyP);
	// return idTyP ;
	// }
	//
	// public Long ajouterNouvelUtilisateur(Utilisateur uti){
	// return daoUtilisateur.ajouter(uti).getId();
	// }
	//
	// public List<Utilisateur> getTousUtl(){
	//
	// return daoUtilisateur.select();
	//
	// }
	//
	// @Override
	// public Utilisateur getUtilisateur(Long id) {
	//
	// return daoUtilisateur.findById(id);
	// }
	//
	// @Override
	// public void supprimierUtl(Long id) {
	//
	// Utilisateur utilisateur = daoUtilisateur.findById(id);
	// daoUtilisateur.delete(utilisateur);;
	//
	// }
	//
	// @Override
	// public Utilisateur upDateUtl(Long id, String libelle, String nom, String
	// prenom) {
	//
	// Utilisateur utilisateur = daoUtilisateur.findById(id);
	// utilisateur.setLibelle(libelle);
	// utilisateur.setNom(nom);
	// utilisateur.setPrenom(prenom);
	// return daoUtilisateur.update(utilisateur);
	// }
}
