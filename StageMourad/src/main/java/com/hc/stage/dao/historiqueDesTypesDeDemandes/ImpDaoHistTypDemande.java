package com.hc.stage.dao.historiqueDesTypesDeDemandes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hc.stage.dao.base.GenericJpaDao;
import com.hc.stage.entities.historisation.historisationDesTypesDeDemandes.HistoriqueTypeDemande;

public class ImpDaoHistTypDemande extends GenericJpaDao<HistoriqueTypeDemande, Long> implements InterfaceDaoHistoriqueTypeDemande{

	@PersistenceContext
	private EntityManager em ;
	
	public ImpDaoHistTypDemande() {
		super(HistoriqueTypeDemande.class);
	}
	public ImpDaoHistTypDemande(Class<HistoriqueTypeDemande> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	}
	


}
