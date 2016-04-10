package org.hn.stage.dao.typeDemandes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hn.stage.dao.base.GenericJpaDao;
import org.hn.stage.entities.typeDemandes.DocumentTypeDemande;

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
