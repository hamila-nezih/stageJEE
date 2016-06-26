package com.hc.stage.dao.demades;

import java.util.List;

import com.hc.stage.dao.base.GenericDao;
import com.hc.stage.entities.demandes.Demande;

public interface InterfaceDaoDemande extends GenericDao<Demande, Long> {
	public List<Demande> getDemandes(Long idC);

}
