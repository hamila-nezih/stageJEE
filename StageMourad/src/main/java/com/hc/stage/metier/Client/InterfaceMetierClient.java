package com.hc.stage.metier.Client;

import java.util.List;

import com.hc.stage.entities.acteurs.Client;
import com.hc.stage.entities.demandes.Demande;
import com.hc.stage.entities.demandes.DocumentDeDemande;
import com.hc.stage.entities.demandes.PrerequisDeDemande;
import com.hc.stage.entities.types.typesDeDemandes.PrerequisTypeDemande;
import com.hc.stage.entities.types.typesDeDemandes.TypeDemande;
public interface InterfaceMetierClient {
	
	public List<TypeDemande> getAllTypeDemande();
	public List<PrerequisTypeDemande> getPrerequisTypeDemande(Long id);
	public List<PrerequisDeDemande> getPrerequisDemande(Long id);
	public List<PrerequisTypeDemande> getTousPreTD();
	
	public TypeDemande getTypeDemande(Long id);
	
	public Long ajouterNouveauClient(Client client);
	public Client findClientId(Long id);
	
	public Long creerNouvelleDemande(Demande demande, Long idC, Long idTDemande);
	public void creerNouveauPrerequis(PrerequisDeDemande prerequisDeDemande);
	public void creerNouveauDocument(DocumentDeDemande documentDeDemande);
	
	 public  List<PrerequisDeDemande>  getPrerequis(Long idDmd);
		
	
	public List<Demande> getDemandes(Long idC);
	
	public Long AjouterNouveauDocumentDemande(DocumentDeDemande doD, Client client);
	public Long AjouterNouveauPrerequi(PrerequisDeDemande prD, Client client);
}
