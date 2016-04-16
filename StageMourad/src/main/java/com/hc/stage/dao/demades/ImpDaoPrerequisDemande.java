package com.hc.stage.dao.demades;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hc.stage.dao.base.GenericJpaDao;
import com.hc.stage.entities.demandes.PrerequisDeDemande;

public class ImpDaoPrerequisDemande  extends GenericJpaDao<PrerequisDeDemande, Long> implements InterfaceDaoPrerequisDemande{

	@PersistenceContext
	private EntityManager em ;
	
	public ImpDaoPrerequisDemande() {
		super(PrerequisDeDemande.class);
	}
	public ImpDaoPrerequisDemande(Class<PrerequisDeDemande> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	}
	

}
