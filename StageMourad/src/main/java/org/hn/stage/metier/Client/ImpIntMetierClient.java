package org.hn.stage.metier.Client;

import org.hn.stage.dao.acteurs.InterfaceDaoClient;
import org.hn.stage.dao.demades.InterfaceDaoDemande;
import org.hn.stage.dao.demades.InterfaceDaoDocumentDemande;
import org.hn.stage.dao.demades.InterfaceDaoPrerequisDemande;
import org.hn.stage.dao.historiqueDesDemandes.InterfaceDaoHisDemande;
import org.hn.stage.dao.historiqueDesDemandes.InterfaceDaoHisDocDemande;
import org.hn.stage.dao.historiqueDesDemandes.InterfaceDaoHisPrerDemande;
import org.hn.stage.dao.typeDemandes.InterfaceDaoTypDemande;
import org.hn.stage.entities.acteurs.Client;
import org.hn.stage.entities.demandes.Demande;
import org.hn.stage.entities.demandes.DocumentDemande;
import org.hn.stage.entities.demandes.PrerequisDemande;
import org.hn.stage.entities.historisationsDesDemandes.HistoriqueDemande;
import org.hn.stage.entities.historisationsDesDemandes.HistoriqueDocumentDemande;
import org.hn.stage.entities.historisationsDesDemandes.HistoriquePrerequisDemande;
import org.hn.stage.entities.typeDemandes.TypeDemande;
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
	public Long creerNouveauDemande(Demande demande, Client client,String id ) {
		
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
	public Long AjouterNouveauDocumentDemande(DocumentDemande doD, Client client) {
		
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
	public Long AjouterNouveauPrerequis(PrerequisDemande prD, Client client) {
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
