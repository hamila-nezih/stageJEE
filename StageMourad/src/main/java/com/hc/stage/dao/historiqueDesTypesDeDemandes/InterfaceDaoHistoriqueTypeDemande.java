package com.hc.stage.dao.historiqueDesTypesDeDemandes;

import java.util.List;

import com.hc.stage.dao.base.GenericDao;
import com.hc.stage.entities.historisation.historisationDesTypesDeDemandes.HistoriqueTypeDemande;

public interface InterfaceDaoHistoriqueTypeDemande extends GenericDao<HistoriqueTypeDemande, Long>{
	

	public List<HistoriqueTypeDemande> getAllHistoriqueTypeDemande();
	public void deleteHistoriqueTypeDemande(Long id);
}
