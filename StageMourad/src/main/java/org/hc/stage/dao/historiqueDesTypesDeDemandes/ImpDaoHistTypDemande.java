package org.hc.stage.dao.historiqueDesTypesDeDemandes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hc.stage.dao.base.GenericJpaDao;
import org.hc.stage.entities.historisation.historisationDesTypesDeDemandes.HistoriqueTypeDemande;

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
