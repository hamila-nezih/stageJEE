package org.hn.stage.dao.historiqueDesDemandes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hn.stage.dao.base.GenericJpaDao;
import org.hn.stage.entities.historisationsDesDemandes.HistoriqueDemande;

public class ImpDaoHisDemande extends GenericJpaDao<HistoriqueDemande, Long> implements InterfaceDaoHisDemande{

	@PersistenceContext
	private EntityManager em ;
	
	public ImpDaoHisDemande() {
		super(HistoriqueDemande.class);
	}
	public ImpDaoHisDemande(Class<HistoriqueDemande> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	} 

}
