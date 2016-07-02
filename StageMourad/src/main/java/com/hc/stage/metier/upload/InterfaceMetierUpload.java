package com.hc.stage.metier.upload;

import com.hc.stage.entities.upload.upload;

public interface InterfaceMetierUpload  {
	
	public Long ajouterNouvelleFichier(upload up );
	public upload getFichier();
//	public Utilisateur getUtilisateur(Long id);
//	public List<Utilisateur> getTousUtl();
//	public void supprimierUtl(Long id);
//	public Utilisateur upDateUtl(Long id, String labelle, String nom, String prenom);
//	
//	
//	public Long AjouterNouveauTypeDocumentDemande(DocumentTypeDemande dTD, Utilisateur utilisateur);
//	public Long AjouterNouveauTypePrerequis(PrerequisTypeDemande pTD, Utilisateur utilisateur);
//	public Long ajouterNouveauTypeDemande(TypeDemande tyD, Utilisateur utilisateur);
//	
//	public List<PrerequisTypeDemande> getTypePrerequisD(Long id);
	
	

}
