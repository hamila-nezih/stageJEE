package com.hc.stage.metier.Client;

import org.springframework.transaction.annotation.Transactional;

import com.hc.stage.dao.acteurs.InterfaceDaoClient;
import com.hc.stage.dao.demades.InterfaceDaoDemande;
import com.hc.stage.dao.demades.InterfaceDaoDocumentDemande;
import com.hc.stage.dao.demades.InterfaceDaoPrerequisDemande;
import com.hc.stage.dao.historiqueDesDemandes.InterfaceDaoHisDemande;
import com.hc.stage.dao.historiqueDesDemandes.InterfaceDaoHisDocDemande;
import com.hc.stage.dao.historiqueDesDemandes.InterfaceDaoHisPrerDemande;
import com.hc.stage.dao.typeDemandes.InterfaceDaoTypDemande;
import com.hc.stage.entities.acteurs.Client;
import com.hc.stage.entities.demandes.Demande;
import com.hc.stage.entities.demandes.DocumentDeDemande;
import com.hc.stage.entities.demandes.PrerequisDeDemande;
import com.hc.stage.entities.types.typesDeDemandes.TypeDemande;

@Transactional
public class ImpIntMetierClient implements InterfaceMetierClient{
	
	private InterfaceDaoClient daoClient ;
	private InterfaceDaoDemande daoDemande;
	private InterfaceDaoHisDemande daoHisDemande;
	private InterfaceDaoDocumentDemande daoDocumentDemande ;
	private InterfaceDaoHisDocDemande daoHisDocDemande ;
	private InterfaceDaoPrerequisDemande daoPrerequisDemande;
	private InterfaceDaoHisPrerDemande daoHisPrerDemande;
	private InterfaceDaoTypDemande daoTypDemande;

	
	public Long ajouterNouveauClient(Client client){
		return daoClient.ajouter(client).getId();
	}

	@Override
	public Long creerNouvelleDemande(Demande demande, Client client,String id ) {
		
		TypeDemande typeDemande = daoTypDemande.findById(Long.parseLong(id));
		demande.setTypeDemande(typeDemande);
		Long idDmd = daoDemande.ajouter(demande).getId();
		demande.setId(idDmd);
		java.util.Date date = new java.util.Date();

        //Date date = dateFormat.parse(dateSysteme);
		//HistoriqueDemande historiqueDemande = new HistoriqueDemande("ajouter",date);
		/*historiqueDemande.setDemande(demande);
		historiqueDemande.setClient(client);
		daoHisDemande.ajouter(historiqueDemande);*/
		return idDmd ;	
		
	}

	@Override
	public Long AjouterNouveauDocumentDemande(DocumentDeDemande doD, Client client) {
		
		Long idDocDmd = daoDocumentDemande.ajouter(doD).getId();
		doD.setId(idDocDmd);
		java.util.Date date = new java.util.Date();
        //Date date = dateFormat.parse(dateSysteme);
		/*HistoriqueDocumentDemande historiqueDocumentDemande = new HistoriqueDocumentDemande("ajouter",date);
		historiqueDocumentDemande.setDocumentDemande(doD);
		historiqueDocumentDemande.setClient(client);
		daoHisDocDemande.ajouter(historiqueDocumentDemande);*/
		return idDocDmd ;	
	}

	@Override
	public Long AjouterNouveauPrerequi(PrerequisDeDemande prD, Client client) {
		Long idPD = daoPrerequisDemande.ajouter(prD).getId();
		prD.setId(idPD);
		java.util.Date date = new java.util.Date();
		/*HistoriquePrerequisDemande historiquePrerequisDemande = new HistoriquePrerequisDemande("ajouter",date);
		historiquePrerequisDemande.setClient(client);
		historiquePrerequisDemande.setPrerequisDemande(prD);
		daoHisPrerDemande.ajouter(historiquePrerequisDemande);*/
		return idPD ;	
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

}
