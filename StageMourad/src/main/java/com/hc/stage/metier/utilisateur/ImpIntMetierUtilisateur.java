package com.hc.stage.metier.utilisateur;

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

	public List<Utilisateur> selectTous(){
		
		return daoUtilisateur.select();
		 
	}
}
