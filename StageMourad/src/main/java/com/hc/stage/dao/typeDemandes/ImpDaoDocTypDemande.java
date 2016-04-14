package com.hc.stage.dao.typeDemandes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hc.stage.dao.base.GenericJpaDao;
import com.hc.stage.entities.types.typesDeDemandes.DocumentTypeDemande;

public class ImpDaoDocTypDemande extends GenericJpaDao<DocumentTypeDemande, Long> implements InterfaceDaoDocumentTypeDemande{

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
