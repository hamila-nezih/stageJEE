package com.hc.stage.dao.typeDemandes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	
	public TypeDemande getFullTypeDemande(Long id){
		
		Query req=em.createQuery("select t from TypeDemande t    left join   t.prerequisTypeDemandes left join   t.documentsTypeDemandes where t.id=:x");	
	     req.setParameter("x",id);
	//System.out.println(req.getResultList().toString());
	     return (TypeDemande) req.getResultList();
		
	}

}
