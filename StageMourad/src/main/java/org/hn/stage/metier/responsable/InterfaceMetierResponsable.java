package org.hn.stage.metier.responsable;

import org.hn.stage.entities.acteurs.Responsable;
import org.hn.stage.entities.acteurs.Utilisateur;
import org.hn.stage.entities.typeDemandes.DocumentTypeDemande;
import org.hn.stage.entities.typeDemandes.PrerequisTypeDemande;
import org.hn.stage.entities.typeDemandes.TypeDemande;

public interface InterfaceMetierResponsable  {
	
	public Long ajouterNouveauTypeDemande(TypeDemande tyD, Responsable responsable);
	public Long AjouterNouveauTypeDocumentDemande(DocumentTypeDemande dTD, Responsable responsable);
	public Long AjouterNouveauTypePrerequis(PrerequisTypeDemande pTD, Responsable responsable);
	
	public Long ajouterNouveauResponsable(Responsable res);
	public Long ajouterNouveauUtilisateur(Utilisateur uti);

	
	

}
