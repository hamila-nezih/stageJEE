package com.hc.stage.dao.demades;

import java.util.List;

import com.hc.stage.dao.base.GenericDao;
import com.hc.stage.entities.demandes.Demande;

public interface InterfaceDaoDemande extends GenericDao<Demande, Long> {
	public List<Demande> getDemandes(Long idC);
	public List<Demande> getDemandesCloture(Long idC);
	public List<Demande> getDemandeHistorique(Long idDemande);
	public List<Demande> getDemandeType(Long idType);
	public List<Demande> getTousDemandesEnAttente();
	public List<Demande> getDemandeHistoriqueEncours(Long idDemande);
}
