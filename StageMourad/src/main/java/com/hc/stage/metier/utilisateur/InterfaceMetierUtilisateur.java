package com.hc.stage.metier.utilisateur;

import java.util.List;

import com.hc.stage.entities.acteurs.Utilisateur;
import com.hc.stage.entities.historisation.historisationDesTypesDeDemandes.HistoriqueTypeDemande;
import com.hc.stage.entities.types.typesDeDemandes.DocumentTypeDemande;
import com.hc.stage.entities.types.typesDeDemandes.PrerequisTypeDemande;
import com.hc.stage.entities.types.typesDeDemandes.TypeDemande;

public interface InterfaceMetierUtilisateur {

	public Long ajouterNouvelUtilisateur(Utilisateur uti);

	public Utilisateur getUtilisateur(Long id);

	public List<Utilisateur> getTousUtl();

	public void supprimierUtl(Long id);

	public Utilisateur upDateUtl(Long id, String labelle, String nom, String prenom);

	public Long AjouterNouveauTypeDocumentDemande(DocumentTypeDemande dTD, Utilisateur utilisateur);

	public Long AjouterNouveauTypePrerequis(PrerequisTypeDemande pTD, Utilisateur utilisateur);

	public Long ajouterNouveauTypeDemande(TypeDemande tyD, Utilisateur utilisateur);

	public List<PrerequisTypeDemande> getTypePrerequisD(Long id);

	public TypeDemande creerNouveauTypeDemande(TypeDemande typeDemande);

	public void creerNouveauTypePrerequisDemande(PrerequisTypeDemande prerequisTypeDemande);

	public void creerNouveauTypeDocumentDemande(DocumentTypeDemande documentTypeDemande);

	public TypeDemande getTypeDemande(Long id);
	
	public List<HistoriqueTypeDemande> getAllHistoriqueTypeDemande();
	
	

}
