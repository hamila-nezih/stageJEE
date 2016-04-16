package com.hc.stage.dao.typeDemandes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hc.stage.dao.base.GenericJpaDao;
import com.hc.stage.entities.types.typesDeDemandes.TypeDemande;

public class ImpDaoTypDemande extends GenericJpaDao<TypeDemande, Long> implements InterfaceDaoTypDemande{

	@PersistenceContext
	private EntityManager em ;
	
	public ImpDaoTypDemande() {
		super(TypeDemande.class);
	}
	public ImpDaoTypDemande(Class<TypeDemande> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	}
	

}
