package org.hc.stage.dao.typeDemandes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hc.stage.dao.base.GenericJpaDao;
import org.hc.stage.entities.types.typesDeDemandes.DocumentTypeDemande;

public class ImpDaoDocTypDemande extends GenericJpaDao<DocumentTypeDemande, Long> implements InterfaceDaoDocTypDemande{

	@PersistenceContext
	private EntityManager em ;
	
	public ImpDaoDocTypDemande() {
		super(DocumentTypeDemande.class);
	}
	public ImpDaoDocTypDemande(Class<DocumentTypeDemande> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	} 

}
