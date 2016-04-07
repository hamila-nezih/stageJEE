package org.hn.stage.metier;

import java.util.List;

import org.hn.stage.entities.acteurs.Client;
import org.hn.stage.entities.acteurs.Responsable;
import org.hn.stage.entities.acteurs.Service;
import org.hn.stage.entities.demandes.Demande;
import org.hn.stage.entities.demandes.DocumentDemande;
import org.hn.stage.entities.demandes.PrerequisDemande;
import org.hn.stage.entities.historisationsDesDemandes.HistoriqueDemande;
import org.hn.stage.entities.historisationsDesDemandes.HistoriqueDocumentDemande;
import org.hn.stage.entities.historisationsDesDemandes.HistoriquePrerequisDemande;
import org.hn.stage.entities.historisationsDesDemandes.HistoriqueServiceDemande;
import org.hn.stage.entities.historisationsDesTypes.HistoriqueTypeDemande;
import org.hn.stage.entities.historisationsDesTypes.HistoriqueTypeDocument;
import org.hn.stage.entities.historisationsDesTypes.HistoriqueTypePrerequis;
import org.hn.stage.entities.typeDemandes.DocumentTypeDemande;
import org.hn.stage.entities.typeDemandes.PrerequisTypeDemande;
import org.hn.stage.entities.typeDemandes.TypeDemande;

public interface InterfaceMetier {

	/******************* org.hn.stage.entities.acteurs *******************/
	
	/******** Client  *********/

	public Long ajouterClient(Client c);
	public List<Client> listClient() ;
	public Client getClient(Long idClient);
	public void supprimerClient(Long idClient);
	public void modifierClient(Client c);

	/******** Responsable  *********/

	public Long ajouterResponsable(Responsable r);
	public List<Responsable> listResponsable() ;
	public Responsable getResponsable(Long idResponsable);
	public void supprimerResponsable(Long idResponsable);
	public void modifierResponsable(Responsable r);
	
	/******** Service  *********/

	public Long ajouterService(Service r);
	public List<Service> listService() ;
	public Service getService(Long idService);
	public void supprimerService(Long idService);
	public void modifierService(Service r);

/******************* org.hn.stage.entities.historisationsDesTypes *******************/


		/******** HistoriqueTypeDemande  *********/

	public Long ajouterHTD(HistoriqueTypeDemande r);
	public List<HistoriqueTypeDemande> listHTD() ;
	public HistoriqueTypeDemande getHTD(Long idHTD);
	public void supprimerHTD(Long idHTD);
	public void modifierHTD(HistoriqueTypeDemande r);

		/******** HistoriqueTypeDocument *********/

	public Long ajouterHTDoc(HistoriqueTypeDocument r);
	public List<HistoriqueTypeDocument> listHTDoc() ;
	public HistoriqueTypeDocument getHTDoc(Long idHTDoc);
	public void supprimerHTDoc(Long idHTDoc);
	public void modifierHTDoc(HistoriqueTypeDocument r);

		/******** HistoriqueTypePrerequis *********/

	public Long ajouterHTP(HistoriqueTypePrerequis r);
	public List<HistoriqueTypePrerequis> listHTP() ;
	public HistoriqueTypePrerequis getHTP(Long idHTP);
	public void supprimerHTP(Long idHTP);
	public void modifierHTP(HistoriqueTypePrerequis r);

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

/******************* org.hn.stage.entities.typeDemandes *******************/


		/******** DocumentTypeDemande  *********/

	public Long ajouterDTD(DocumentTypeDemande r);
	public List<DocumentTypeDemande> listDTD() ;
	public DocumentTypeDemande getDTD(Long idDTD);
	public void supprimerDTD(Long idDTD);
	public void modifierDTD(DocumentTypeDemande r);

		/******** PrerequisTypeDemande *********/

	public Long ajouterPTD(PrerequisTypeDemande r);
	public List<PrerequisTypeDemande> listPTD() ;
	public PrerequisTypeDemande getPTD(Long idPTD);
	public void supprimerPTD(Long idPTD);
	public void modifierPTD(PrerequisTypeDemande r);

		/******** TypeDemande *********/

	public Long ajouterTyD(TypeDemande r);	
	public List<TypeDemande> listTyD() ;
	public TypeDemande getTyD(Long idTyD);
	public void supprimerTyD(Long idTyD);
	public void modifierTyD(TypeDemande r);

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


/******** HistoriqueServiceDemande *********/

	public Long ajouterHSD(HistoriqueServiceDemande r);
	public List<HistoriqueServiceDemande> listHSD() ;
	public HistoriqueServiceDemande getHSD(Long idHSD);
	public void supprimerHSD(Long idHSD);
	public void modifierHSD(HistoriqueServiceDemande r);
}
