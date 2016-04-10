package org.hn.stage.dao.typeDemandes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hn.stage.dao.base.GenericJpaDao;

import org.hn.stage.entities.typeDemandes.PrerequisTypeDemande;

public class ImpDaoPreTypDemande  extends GenericJpaDao<PrerequisTypeDemande, Long> implements InterfaceDaoPreTypDemande{

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
