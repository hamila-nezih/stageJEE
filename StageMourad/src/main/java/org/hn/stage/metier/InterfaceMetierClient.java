package org.hn.stage.metier;

import java.util.List;

import org.hn.stage.entities.acteurs.Client;
import org.hn.stage.entities.demandes.Demande;
import org.hn.stage.entities.demandes.DocumentDemande;
import org.hn.stage.entities.demandes.PrerequisDemande;
import org.hn.stage.entities.historisationsDesDemandes.HistoriqueDemande;
import org.hn.stage.entities.historisationsDesDemandes.HistoriqueDocumentDemande;
import org.hn.stage.entities.historisationsDesDemandes.HistoriquePrerequisDemande;

public interface InterfaceMetierClient {
	
	/******************* org.hn.stage.entities.acteurs *******************/	
	               
	                      /******** Client  *********/
	
	public Long ajouterClient(Client c);
	public List<Client> listClient() ;
	public Client getClient(Long idClient);
	public void supprimerClient(Long idClient);
	public void modifierClient(Client c);
	
	/******************* 	historisationsDesDemandes *******************/

	
						/******** HistoriqueDemande  *********/

	public Long ajouterHDm(HistoriqueDemande r);
	public List<HistoriqueDemande> listHDm() ;
	public HistoriqueDemande getHDm(Long idHDm);
	public void supprimerHDm(Long idHDm);
	public void modifierHDm(HistoriqueDemande r);

					/******** HistoriqueDocumentDemande *********/

	public Long ajouterHDD(HistoriqueDocumentDemande r);
	public List<HistoriqueDocumentDemande> listHDD() ;
	public HistoriqueDocumentDemande getHDD(Long idHDD);
	public void supprimerHDD(Long idHDD);
	public void modifierHDD(HistoriqueDocumentDemande r);

	/******** HistoriquePrerequisDemande *********/

	public Long ajouterHPD(HistoriquePrerequisDemande r);	
	public List<HistoriquePrerequisDemande> listHPD() ;
	public HistoriquePrerequisDemande getHPD(Long idHPD);
	public void supprimerHPD(Long idHPD);
	public void modifierHPD(HistoriquePrerequisDemande r);
	
	
	/******************* org.hn.stage.entities.demandes *******************/

	
	    /******** Demande  *********/

	public Long ajouterDmd(Demande r);
	public List<Demande> listDmd() ;
	public Demande getDmd(Long idDmd);
	public void supprimerDmd(Long idDmd);
	public void modifierDmd(Demande r);
	
		/******** DocumentDemande *********/

	public Long ajouterDoD(DocumentDemande r);
	public List<DocumentDemande> listDoD() ;
	public DocumentDemande getDoD(Long idDoD);
	public void supprimerDoD(Long idDoD);
	public void modifierDoD(DocumentDemande r);

	    /******** PrerequisDemande *********/

	public Long ajouterPrD(PrerequisDemande r);
	public List<PrerequisDemande> listPrD() ;
	public PrerequisDemande getPrD(Long idPrD);
	public void supprimerPrD(Long idPrD);
	public void modifierPrD(PrerequisDemande r);

}
