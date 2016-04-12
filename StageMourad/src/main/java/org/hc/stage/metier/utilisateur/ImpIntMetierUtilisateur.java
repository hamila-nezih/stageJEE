package org.hc.stage.metier.utilisateur;

import org.hc.stage.dao.acteurs.InterfaceDaoUtilisateur;
import org.hc.stage.dao.historiqueDesTypesDeDemandes.InterfaceDaoHistoriqueTypeDemande;
import org.hc.stage.dao.typeDemandes.InterfaceDaoDocumentTypeDemande;
import org.hc.stage.dao.typeDemandes.InterfaceDaoPrerequisTypeDemande;
import org.hc.stage.dao.typeDemandes.InterfaceDaoTypDemande;
import org.hc.stage.entities.acteurs.Utilisateur;
import org.hc.stage.entities.historisation.historisationDesTypesDeDemandes.HistoriqueTypeDemande;
import org.hc.stage.entities.types.typesDeDemandes.DocumentTypeDemande;
import org.hc.stage.entities.types.typesDeDemandes.PrerequisTypeDemande;
import org.hc.stage.entities.types.typesDeDemandes.TypeDemande;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class ImpIntMetierUtilisateur implements InterfaceMetierUtilisateur{

	private InterfaceDaoUtilisateur daoUtilisateur;
	private InterfaceDaoTypDemande daoTypDemande;
	private InterfaceDaoDocumentTypeDemande daoDocumentTypeDemande;
	private InterfaceDaoPrerequisTypeDemande daoPrerequisTypeDemande;
	private InterfaceDaoHistoriqueTypeDemande daoHistoriqueTypeDemande; 
	
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
	
	public Long ajouterNouveauTypeDemande(TypeDemande tyD,Utilisateur utilisateur){
		
		Long idTyD = daoTypDemande.ajouter(tyD).getId();
	    tyD.setId(idTyD);
	    HistoriqueTypeDemande historiqueTypeDemande = new HistoriqueTypeDemande();
	    historiqueTypeDemande.setCommentaire("premier ajout ");
	    historiqueTypeDemande.setTypeDemande(tyD);
	    historiqueTypeDemande.setUtilisateur(utilisateur);
	    daoHistoriqueTypeDemande.ajouter(historiqueTypeDemande);
	    return idTyD ;
	}
	
	public Long AjouterNouveauTypeDocumentDemande(DocumentTypeDemande dTD, Utilisateur utilisateur){
		
		dTD.setUtilisateur(utilisateur);
		Long idTyDoc = daoDocumentTypeDemande.ajouter(dTD).getId();
		dTD.setId(idTyDoc);
	    return idTyDoc ;
	}
	
	public Long AjouterNouveauTypePrerequis(PrerequisTypeDemande pTD, Utilisateur utilisateur){
		
		pTD.setUtilisateur(utilisateur);
		Long idTyP = daoPrerequisTypeDemande.ajouter(pTD).getId();
		pTD.setId(idTyP);
	    return idTyP ;
	}

	public Long ajouterNouvelUtilisateur(Utilisateur uti){
		return daoUtilisateur.ajouter(uti).getId();
	}

}
