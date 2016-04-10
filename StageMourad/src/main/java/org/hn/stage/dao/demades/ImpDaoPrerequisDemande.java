package org.hn.stage.dao.demades;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hn.stage.dao.base.GenericJpaDao;
import org.hn.stage.entities.demandes.PrerequisDemande;

public class ImpDaoPrerequisDemande  extends GenericJpaDao<PrerequisDemande, Long> implements InterfaceDaoPrerequisDemande{

	@PersistenceContext
	private EntityManager em ;
	
	public ImpDaoPrerequisDemande() {
		super(PrerequisDemande.class);
	}
	public ImpDaoPrerequisDemande(Class<PrerequisDemande> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	} 

}
