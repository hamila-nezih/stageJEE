package org.hn.stage.dao.typeDemandes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hn.stage.dao.base.GenericJpaDao;
import org.hn.stage.entities.typeDemandes.TypeDemande;

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
