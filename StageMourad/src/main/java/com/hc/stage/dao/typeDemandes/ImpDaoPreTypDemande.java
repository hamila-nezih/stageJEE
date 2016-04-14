package com.hc.stage.dao.typeDemandes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hc.stage.dao.base.GenericJpaDao;
import com.hc.stage.entities.types.typesDeDemandes.PrerequisTypeDemande;

public class ImpDaoPreTypDemande  extends GenericJpaDao<PrerequisTypeDemande, Long> implements InterfaceDaoPrerequisTypeDemande{

	@PersistenceContext
	private EntityManager em ;
	
	public ImpDaoPreTypDemande() {
		super(PrerequisTypeDemande.class);
	}
	public ImpDaoPreTypDemande(Class<PrerequisTypeDemande> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	} 

}
