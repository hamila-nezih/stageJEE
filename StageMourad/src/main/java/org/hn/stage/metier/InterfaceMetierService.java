package org.hn.stage.metier;

import java.util.List;

import org.hn.stage.entities.acteurs.Service;
import org.hn.stage.entities.historisationsDesDemandes.HistoriqueServiceDemande;

public interface InterfaceMetierService {
	
	/******************* org.hn.stage.entities.acteurs *******************/

	/******** Service  *********/
	
	public Long ajouterService(Service r);
	public List<Service> listService() ;
	public Service getService(Long idService);
	public void supprimerService(Long idService);
	public void modifierService(Service r);
	
	/******************* 	historisationsDesDemandes *******************/
	
	/******** HistoriqueServiceDemande *********/
	
	public Long ajouterHSD(HistoriqueServiceDemande r);
	public List<HistoriqueServiceDemande> listHSD() ;
	public HistoriqueServiceDemande getHSD(Long idHSD);
	public void supprimerHSD(Long idHSD);
	public void modifierHSD(HistoriqueServiceDemande r);

}
