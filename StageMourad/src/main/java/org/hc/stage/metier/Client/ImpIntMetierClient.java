package org.hc.stage.metier.Client;

import org.hc.stage.dao.acteurs.InterfaceDaoClient;
import org.hc.stage.dao.demades.InterfaceDaoDemande;
import org.hc.stage.dao.demades.InterfaceDaoDocumentDemande;
import org.hc.stage.dao.demades.InterfaceDaoPrerequisDemande;
import org.hc.stage.dao.historiqueDesDemandes.InterfaceDaoHisDemande;
import org.hc.stage.dao.historiqueDesDemandes.InterfaceDaoHisDocDemande;
import org.hc.stage.dao.historiqueDesDemandes.InterfaceDaoHisPrerDemande;
import org.hc.stage.dao.typeDemandes.InterfaceDaoTypDemande;
import org.hc.stage.entities.acteurs.Client;
import org.hc.stage.entities.demandes.Demande;
import org.hc.stage.entities.demandes.DocumentDeDemande;
import org.hc.stage.entities.demandes.PrerequisDeDemande;
import org.hc.stage.entities.historisation.historisationDesDemandes.HistoriqueDemande;
import org.hc.stage.entities.historisation.historisationDesDemandes.HistoriqueDocumentDemande;
import org.hc.stage.entities.historisation.historisationDesDemandes.HistoriquePrerequisDemande;
import org.hc.stage.entities.types.typesDeDemandes.TypeDemande;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ImpIntMetierClient implements InterfaceMetierClient{
	
	private InterfaceDaoClient daoClient ;
	private InterfaceDaoDemande daoDemande;
	private InterfaceDaoHisDemande daoHisDemande;
	private InterfaceDaoDocumentDemande daoDocumentDemande ;
	private InterfaceDaoHisDocDemande daoHisDocDemande ;
	private InterfaceDaoPrerequisDemande daoPrerequisDemande;
	private InterfaceDaoHisPrerDemande daoHisPrerDemande;
	private InterfaceDaoTypDemande daoTyd;

	
	public Long ajouterNouveauClient(Client client){
		return daoClient.ajouter(client).getId();
	}

	@Override
	public Long creerNouvelleDemande(Demande demande, Client client,String id ) {
		
		TypeDemande typeDemande = daoTyd.findById(Long.parseLong(id));
		demande.setTypeDemande(typeDemande);
		Long idDmd = daoDemande.ajouter(demande).getId();
		demande.setId(idDmd);
		java.util.Date date = new java.util.Date();

        //Date date = dateFormat.parse(dateSysteme);
		HistoriqueDemande historiqueDemande = new HistoriqueDemande("ajouter",date);
		historiqueDemande.setDemande(demande);
		historiqueDemande.setClient(client);
		daoHisDemande.ajouter(historiqueDemande);
		return idDmd ;	
		
	}

	@Override
	public Long AjouterNouveauDocumentDemande(DocumentDeDemande doD, Client client) {
		
		Long idDocDmd = daoDocumentDemande.ajouter(doD).getId();
		doD.setId(idDocDmd);
		java.util.Date date = new java.util.Date();
        //Date date = dateFormat.parse(dateSysteme);
		HistoriqueDocumentDemande historiqueDocumentDemande = new HistoriqueDocumentDemande("ajouter",date);
		historiqueDocumentDemande.setDocumentDemande(doD);
		historiqueDocumentDemande.setClient(client);
		daoHisDocDemande.ajouter(historiqueDocumentDemande);
		return idDocDmd ;	
	}

	@Override
	public Long AjouterNouveauPrerequi(PrerequisDeDemande prD, Client client) {
		Long idPD = daoPrerequisDemande.ajouter(prD).getId();
		prD.setId(idPD);
		java.util.Date date = new java.util.Date();
		HistoriquePrerequisDemande historiquePrerequisDemande = new HistoriquePrerequisDemande("ajouter",date);
		historiquePrerequisDemande.setClient(client);
		historiquePrerequisDemande.setPrerequisDemande(prD);
		daoHisPrerDemande.ajouter(historiquePrerequisDemande);
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

	public void setDaoTyd(InterfaceDaoTypDemande daoTyd) {
		this.daoTyd = daoTyd;
	}

}
