package com.hc.stage.dao.typeDemandes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	@Override
	public void deleteDocumentTypeDemande(Long id) {
		Query req = em.createQuery(" delete from DocumentTypeDemande d where d.typeDemande.id=:x ");
		req.setParameter("x", id);
		req.executeUpdate();
		System.out.print("delete documet");
		
	}
	

}
