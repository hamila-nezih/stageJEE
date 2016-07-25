package com.hc.stage.dao.historiqueDesDemandes;

import java.util.List;

import com.hc.stage.dao.base.GenericDao;
import com.hc.stage.entities.demandes.Demande;
import com.hc.stage.entities.historisation.historisationDesDemandes.HistoriqueDemande;

public interface InterfaceDaoHisDemande extends GenericDao<HistoriqueDemande, Long>{
	
	public List<HistoriqueDemande> getDemandeHistoriqueEncours(Long id);

}
