package org.hc.stage.dao.historiqueDesDemandes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hc.stage.dao.base.GenericJpaDao;
import org.hc.stage.entities.historisation.historisationDesDemandes.HistoriqueDocumentDemande;

public class ImpDaoHisDocDemande extends GenericJpaDao<HistoriqueDocumentDemande, Long> implements InterfaceDaoHisDocDemande{

	@PersistenceContext
	private EntityManager em ;
	
	public ImpDaoHisDocDemande() {
		super(HistoriqueDocumentDemande.class);
	}
	public ImpDaoHisDocDemande(Class<HistoriqueDocumentDemande> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	} 

}
