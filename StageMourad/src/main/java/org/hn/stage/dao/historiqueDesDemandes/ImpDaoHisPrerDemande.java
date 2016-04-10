package org.hn.stage.dao.historiqueDesDemandes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hn.stage.dao.base.GenericJpaDao;
import org.hn.stage.entities.historisationsDesDemandes.HistoriquePrerequisDemande;

public class ImpDaoHisPrerDemande extends GenericJpaDao<HistoriquePrerequisDemande, Long> implements InterfaceDaoHisPrerDemande{

	@PersistenceContext
	private EntityManager em ;
	
	public ImpDaoHisPrerDemande() {
		super(HistoriquePrerequisDemande.class);
	}
	public ImpDaoHisPrerDemande(Class<HistoriquePrerequisDemande> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	} 

}
