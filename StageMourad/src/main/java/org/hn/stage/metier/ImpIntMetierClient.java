package org.hn.stage.metier;

import java.util.List;

import org.hn.stage.dao.InterfaceDao;
import org.hn.stage.entities.acteurs.Client;
import org.hn.stage.entities.demandes.Demande;
import org.hn.stage.entities.demandes.DocumentDemande;
import org.hn.stage.entities.demandes.PrerequisDemande;
import org.hn.stage.entities.historisationsDesDemandes.HistoriqueDemande;
import org.hn.stage.entities.historisationsDesDemandes.HistoriqueDocumentDemande;
import org.hn.stage.entities.historisationsDesDemandes.HistoriquePrerequisDemande;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class ImpIntMetierClient implements InterfaceMetierClient{
	
	private InterfaceDao dao ;

	public void setDao(InterfaceDao dao) {
		this.dao = dao;
	}
	
					/******************* org.hn.stage.entities.acteurs *******************/	
    
	/******** Client  *********/

	public Long ajouterClient(Client c){
		return dao.ajouterClient(c);	
	}
	public List<Client> listClient() {
		return dao.listClient();	
	}
	public Client getClient(Long idClient){
		return dao.getClient(idClient);	
	}
	public void supprimerClient(Long idClient){
		dao.supprimerClient(idClient);	
	}
	public void modifierClient(Client c){
		dao.modifierClient(c);	
	}

				/******************* 	historisationsDesDemandes *******************/

	/******** HistoriqueDemande  *********/

	public Long ajouterHDm(HistoriqueDemande r){
		return dao.ajouterHDm(r);	
	}
	public List<HistoriqueDemande> listHDm(){
		return dao.listHDm();	
	}
	public HistoriqueDemande getHDm(Long idHDm){
		return dao.getHDm(idHDm);	
	}
	public void supprimerHDm(Long idHDm){
		dao.supprimerHDm(idHDm);	
	}
	public void modifierHDm(HistoriqueDemande r){
		dao.modifierHDm(r);	
	}

/******** HistoriqueDocumentDemande *********/

	public Long ajouterHDD(HistoriqueDocumentDemande r){
		return dao.ajouterHDD(r);	
	}
	public List<HistoriqueDocumentDemande> listHDD(){
		return dao.listHDD();	
	}
	public HistoriqueDocumentDemande getHDD(Long idHDD){
		return dao.getHDD(idHDD);	
	}
	public void supprimerHDD(Long idHDD){
		dao.supprimerHDD(idHDD);	
	}
	public void modifierHDD(HistoriqueDocumentDemande r){
		dao.modifierHDD(r);	
	}

/******** HistoriquePrerequisDemande *********/

	public Long ajouterHPD(HistoriquePrerequisDemande r){
		return dao.ajouterHPD(r);	
	}
	public List<HistoriquePrerequisDemande> listHPD(){
		return dao.listHPD();	
	}
	public HistoriquePrerequisDemande getHPD(Long idHPD){
		return dao.getHPD(idHPD);	
	}
	public void supprimerHPD(Long idHPD){
		dao.supprimerHPD(idHPD);	
	}
	public void modifierHPD(HistoriquePrerequisDemande r){
		dao.modifierHPD(r);	
	}


				/******************* org.hn.stage.entities.demandes *******************/

/******** Demande  *********/

	public Long ajouterDmd(Demande r){
		return dao.ajouterDmd(r);	
	}
	public List<Demande> listDmd(){
		return dao.listDmd();	
	}
	public Demande getDmd(Long idDmd){
		return dao.getDmd(idDmd);	
	}
	public void supprimerDmd(Long idDmd){
		dao.supprimerDmd(idDmd);	
	}
	public void modifierDmd(Demande r){
		dao.modifierDmd(r);	
	}

/******** DocumentDemande *********/

	public Long ajouterDoD(DocumentDemande r){
		return dao.ajouterDoD(r);	
	}
	public List<DocumentDemande> listDoD(){
		return dao.listDoD();	
	}
	public DocumentDemande getDoD(Long idDoD){
		return dao.getDoD(idDoD);	
	}
	public void supprimerDoD(Long idDoD){
		dao.supprimerDoD(idDoD);	
	}
	public void modifierDoD(DocumentDemande r){
		dao.modifierDoD(r);	
	}

/******** PrerequisDemande *********/

	public Long ajouterPrD(PrerequisDemande r){
		return dao.ajouterPrD(r);	
	}
	public List<PrerequisDemande> listPrD(){
		return dao.listPrD();	
	}
	public PrerequisDemande getPrD(Long idPrD){
		return dao.getPrD(idPrD);	
	}
	public void supprimerPrD(Long idPrD){
		dao.supprimerPrD(idPrD);	
	}
	public void modifierPrD(PrerequisDemande r){
		dao.modifierPrD(r);	
	}

}
