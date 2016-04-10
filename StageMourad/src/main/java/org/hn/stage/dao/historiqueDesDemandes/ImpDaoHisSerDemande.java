package org.hn.stage.dao.historiqueDesDemandes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hn.stage.dao.base.GenericJpaDao;
import org.hn.stage.entities.historisationsDesDemandes.HistoriqueServiceDemande;

public class ImpDaoHisSerDemande extends GenericJpaDao<HistoriqueServiceDemande, Long> implements InterfaceDaoHisSerDemande{

	@PersistenceContext
	private EntityManager em ;
	
	public ImpDaoHisSerDemande() {
		super(HistoriqueServiceDemande.class);
	}
	public ImpDaoHisSerDemande(Class<HistoriqueServiceDemande> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	} 
}
