package com.hc.stage.metier.Client;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.hc.stage.dao.acteurs.InterfaceDaoClient;
import com.hc.stage.dao.demades.InterfaceDaoDemande;
import com.hc.stage.dao.demades.InterfaceDaoDocumentDemande;
import com.hc.stage.dao.demades.InterfaceDaoPrerequisDemande;
import com.hc.stage.dao.historiqueDesDemandes.InterfaceDaoHisDemande;
import com.hc.stage.dao.historiqueDesDemandes.InterfaceDaoHisDocDemande;
import com.hc.stage.dao.historiqueDesDemandes.InterfaceDaoHisPrerDemande;
import com.hc.stage.dao.typeDemandes.InterfaceDaoPrerequisTypeDemande;
import com.hc.stage.dao.typeDemandes.InterfaceDaoTypDemande;
import com.hc.stage.entities.acteurs.Client;
import com.hc.stage.entities.demandes.Demande;
import com.hc.stage.entities.demandes.DocumentDeDemande;
import com.hc.stage.entities.demandes.PrerequisDeDemande;
import com.hc.stage.entities.historisation.historisationDesDemandes.HistoriqueDemande;
import com.hc.stage.entities.historisation.historisationDesDemandes.HistoriqueDocumentDemande;
import com.hc.stage.entities.historisation.historisationDesDemandes.HistoriquePrerequisDemande;
import com.hc.stage.entities.types.typesDeDemandes.PrerequisTypeDemande;
import com.hc.stage.entities.types.typesDeDemandes.TypeDemande;

@Transactional
public class ImpIntMetierClient implements InterfaceMetierClient {

	private InterfaceDaoClient daoClient;
	private InterfaceDaoDemande daoDemande;
	private InterfaceDaoHisDemande daoHisDemande;
	private InterfaceDaoDocumentDemande daoDocumentDemande;
    private InterfaceDaoHisDocDemande daoHisDocDemande ;
	private InterfaceDaoPrerequisDemande daoPrerequisDemande;
    private InterfaceDaoHisPrerDemande daoHisPrerDemande;
	private InterfaceDaoTypDemande daoTypDemande;
	private InterfaceDaoPrerequisTypeDemande daoPrerequisTypeDemande;

	@Override
	public TypeDemande getTypeDemande(Long id) {
		return daoTypDemande.getFullTypeDemande(id);
	}

	@Override
	public List<PrerequisTypeDemande> getPrerequisTypeDemande(Long id) {

		return daoPrerequisTypeDemande.getPrerequisTypeDemande(id);
	}

	public Long ajouterNouveauClient(Client client) {
		return daoClient.ajouter(client).getId();
	}

	@Override
	public Long creerNouvelleDemande(Demande demande, Long idC, Long idTDemande) {

		TypeDemande typeDemande = daoTypDemande.findById(idTDemande);
		demande.setTypeDemande(typeDemande);
		Client client = daoClient.findById(idC);
		demande.setClient(client);
		demande = daoDemande.ajouter(demande);
		return demande.getId();

	}

	@Override
	public Long AjouterNouveauDocumentDemande(DocumentDeDemande doD, Client client) {

		Long idDocDmd = daoDocumentDemande.ajouter(doD).getId();
		doD.setId(idDocDmd);
		// java.util.Date date = new java.util.Date();
		// Date date = dateFormat.parse(dateSysteme);
		/*
		 * HistoriqueDocumentDemande historiqueDocumentDemande = new
		 * HistoriqueDocumentDemande("ajouter",date);
		 * historiqueDocumentDemande.setDocumentDemande(doD);
		 * historiqueDocumentDemande.setClient(client);
		 * daoHisDocDemande.ajouter(historiqueDocumentDemande);
		 */
		return idDocDmd;
	}

	@Override
	public Long AjouterNouveauPrerequi(PrerequisDeDemande prD, Client client) {
		Long idPD = daoPrerequisDemande.ajouter(prD).getId();
		prD.setId(idPD);
		// java.util.Date date = new java.util.Date();
		/*
		 * HistoriquePrerequisDemande historiquePrerequisDemande = new
		 * HistoriquePrerequisDemande("ajouter",date);
		 * historiquePrerequisDemande.setClient(client);
		 * historiquePrerequisDemande.setPrerequisDemande(prD);
		 * daoHisPrerDemande.ajouter(historiquePrerequisDemande);
		 */
		return idPD;
	}

	public void setDaoPrerequisTypeDemande(InterfaceDaoPrerequisTypeDemande daoPrerequisTypeDemande) {
		this.daoPrerequisTypeDemande = daoPrerequisTypeDemande;
	}

	public InterfaceDaoHisDemande getDaoHisDemande() {
		return daoHisDemande;
	}

	public void setDaoClient(InterfaceDaoClient daoClient) {
		this.daoClient = daoClient;
	}

	public void setDaoDemande(InterfaceDaoDemande daoDemande) {
		this.daoDemande = daoDemande;
	}

	public void setDaoDocumentDemande(InterfaceDaoDocumentDemande daoDocumentDemande) {
		this.daoDocumentDemande = daoDocumentDemande;
	}

	public void setDaoHisDocDemande(InterfaceDaoHisDocDemande daoHisDocDemande) {
		 this.daoHisDocDemande = daoHisDocDemande;
	}

	public void setDaoPrerequisDemande(InterfaceDaoPrerequisDemande daoPrerequisDemande) {
		this.daoPrerequisDemande = daoPrerequisDemande;
	}

	public void setDaoHisPrerDemande(InterfaceDaoHisPrerDemande daoHisPrerDemande) {
		 this.daoHisPrerDemande = daoHisPrerDemande;
	}

	public void setDaoHisDemande(InterfaceDaoHisDemande daoHisDemande) {
		this.daoHisDemande = daoHisDemande;
	}

	public void setDaoTypDemande(InterfaceDaoTypDemande daoTypDemande) {
		this.daoTypDemande = daoTypDemande;
	}

	@Override
	public List<PrerequisDeDemande> getPrerequisDemande(Long id) {

		daoPrerequisDemande.getPrerequisDemande(id);
		return null;
	}

	@Override
	public List<PrerequisTypeDemande> getTousPreTD() {

		return daoPrerequisTypeDemande.select();

	}

	@Override
	public List<TypeDemande> getAllTypeDemande() {

		return daoTypDemande.getAllTypeDemande();
	}

	@Override
	public Client findClientId(Long id) {
		return daoClient.findById(id);
	}

	@Override
	public void creerNouveauPrerequis(PrerequisDeDemande prerequisDeDemande) {
		daoPrerequisDemande.ajouter(prerequisDeDemande);

	}

	@Override
	public void creerNouveauDocument(DocumentDeDemande documentDeDemande) {
		daoDocumentDemande.ajouter(documentDeDemande);

	}

	@Override
	public List<Demande> getDemandes(Long idC) {

		return daoDemande.getDemandes(idC);
	}

	@Override
	public List<PrerequisDeDemande> getPrerequis(Long idDmd) {
		return daoPrerequisDemande.getPrerequis(idDmd);
	}
	
	@Override
	public List<PrerequisDeDemande> getPrerequisHist(Long idDmd) {
		return daoPrerequisDemande.getPrerequisHist(idDmd);
	}

	@Override
	public List<DocumentDeDemande> getDocuments(Long idDmd) {
		return daoDocumentDemande.getDocument(idDmd);
	}
	
	@Override
	public List<DocumentDeDemande> getDocumentsHist(Long idDmd) {
		return daoDocumentDemande.getDocumentHist(idDmd);
	}

	@Override
	public DocumentDeDemande download(Long idDocument) {
		return daoDocumentDemande.findById(idDocument);
	}

	@Override
	public HistoriqueDemande creerHistoriqueDemande(HistoriqueDemande historiqueDemande) {
		return daoHisDemande.ajouter(historiqueDemande);
		
	}

	@Override
	public void creerHistoriquePrerequis(HistoriquePrerequisDemande historiquePrerequisDemande) {
		daoHisPrerDemande.ajouter(historiquePrerequisDemande);
		
	}

	@Override
	public void creerHistoriqueDocument(HistoriqueDocumentDemande historiqueDocumentDemande) {
        daoHisDocDemande.ajouter(historiqueDocumentDemande);
	}

	@Override
	public List<Demande> getDemandesCloture(Long idC) {
		 return daoDemande.getDemandesCloture(idC);
	}

	@Override
	public List<Demande>  getDemandeHistorique(Long idDemande) {
		
		return daoDemande.getDemandeHistorique(idDemande);
	}

	@Override
	public void updateDemande(Demande demande) {
		Demande dmd = daoDemande.findById(demande.getId());
		dmd.setDateModification(demande.getDateModification());
		dmd.setEtat(demande.getEtat());
		daoDemande.update(dmd);		
	}

	@Override
	public List<Client> connexion(String login, String password) {
		return daoClient.connexion(login, password);
	}

	@Override
	public void updateClient(Client client) {
		daoClient.update(client);
		
	}

}
