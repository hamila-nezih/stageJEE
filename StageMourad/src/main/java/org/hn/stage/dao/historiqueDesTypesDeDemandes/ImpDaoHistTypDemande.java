package org.hn.stage.dao.historiqueDesTypesDeDemandes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hn.stage.dao.base.GenericJpaDao;
import org.hn.stage.entities.historisationsDesTypesDeDemandes.HistoriqueTypeDemande;

public class ImpDaoHistTypDemande extends GenericJpaDao<HistoriqueTypeDemande, Long> implements InterfaceDaoHistTypDemande{

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
