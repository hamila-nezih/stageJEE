package com.hc.stage.metier.Client;

import java.util.List;

import com.hc.stage.entities.acteurs.Client;
import com.hc.stage.entities.demandes.Demande;
import com.hc.stage.entities.demandes.DocumentDeDemande;
import com.hc.stage.entities.demandes.PrerequisDeDemande;
import com.hc.stage.entities.historisation.historisationDesDemandes.HistoriqueDemande;
import com.hc.stage.entities.historisation.historisationDesDemandes.HistoriqueDocumentDemande;
import com.hc.stage.entities.historisation.historisationDesDemandes.HistoriquePrerequisDemande;
import com.hc.stage.entities.types.typesDeDemandes.PrerequisTypeDemande;
import com.hc.stage.entities.types.typesDeDemandes.TypeDemande;
public interface InterfaceMetierClient {
	
	public List<TypeDemande> getAllTypeDemande();
	public List<PrerequisTypeDemande> getPrerequisTypeDemande(Long id);
	public List<PrerequisDeDemande> getPrerequisDemande(Long id);
	public List<PrerequisTypeDemande> getTousPreTD();
	
	public TypeDemande getTypeDemande(Long id);
	
	public List<Client> connexion(String login, String password) ;
	public void updateClient(Client client);
	public Long ajouterNouveauClient(Client client);
	public Client findClientId(Long id);
	
	public Long creerNouvelleDemande(Demande demande, Long idC, Long idTDemande);
	public void creerNouveauPrerequis(PrerequisDeDemande prerequisDeDemande);
	public void creerNouveauDocument(DocumentDeDemande documentDeDemande);
	
	public HistoriqueDemande creerHistoriqueDemande(HistoriqueDemande demande);
	public void creerHistoriquePrerequis(HistoriquePrerequisDemande historiquePrerequisDemande);
	public void creerHistoriqueDocument(HistoriqueDocumentDemande historiqueDocumentDemande);
	
	 public  List<PrerequisDeDemande>  getPrerequis(Long idDmd);
	 public  List<DocumentDeDemande>  getDocuments(Long idDmd);
	 
	 public DocumentDeDemande download(Long idDocument);
		
	
	public List<Demande> getDemandeHistorique(Long idDemande);
	public List<Demande> getDemandes(Long idC);
	public List<Demande> getDemandesCloture(Long idC);
	
	public Long AjouterNouveauDocumentDemande(DocumentDeDemande doD, Client client);
	public Long AjouterNouveauPrerequi(PrerequisDeDemande prD, Client client);
	public List<PrerequisDeDemande> getPrerequisHist(Long idDmd);
	public List<DocumentDeDemande> getDocumentsHist(Long idDmd);
	public void updateDemande(Demande demande);
	public List<Demande> getDemandeParType(Long idType);
	
	public void deleteTypeDemande(Long id);
	public List<Demande> getTousDemandesEnAttente();
}
