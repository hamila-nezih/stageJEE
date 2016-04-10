package org.hc.stage.metier.responsable;

import org.hc.stage.entities.acteurs.Utilisateur;
import org.hc.stage.entities.types.typesDeDemandes.DocumentTypeDemande;
import org.hc.stage.entities.types.typesDeDemandes.PrerequisTypeDemande;
import org.hc.stage.entities.types.typesDeDemandes.TypeDemande;

public interface InterfaceMetierUtilisateur  {
	
	public Long ajouterNouveauTypeDemande(TypeDemande tyD, Utilisateur utilisateur);
	public Long AjouterNouveauTypeDocumentDemande(DocumentTypeDemande dTD, Utilisateur utilisateur);
	public Long AjouterNouveauTypePrerequis(PrerequisTypeDemande pTD, Utilisateur utilisateur);
	
	public Long ajouterNouveauResponsable(Utilisateur res);
	public Long ajouterNouveauUtilisateur(Utilisateur uti);

	
	

}
