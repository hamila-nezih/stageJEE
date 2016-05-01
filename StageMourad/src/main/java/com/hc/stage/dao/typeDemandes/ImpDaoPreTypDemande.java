package com.hc.stage.dao.typeDemandes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.hc.stage.dao.base.GenericJpaDao;
import com.hc.stage.entities.types.typesDeDemandes.PrerequisTypeDemande;

@Transactional
public class ImpDaoPreTypDemande  extends GenericJpaDao<PrerequisTypeDemande, Long> implements InterfaceDaoPrerequisTypeDemande{

	@PersistenceContext
	private EntityManager em ;
	
	public ImpDaoPreTypDemande() {
		super(PrerequisTypeDemande.class);
	}
	public ImpDaoPreTypDemande(Class<PrerequisTypeDemande> persistentClass) {
		super(persistentClass);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PrerequisTypeDemande> getPrerequisTypeDemande(Long id) {
		
		Query req=em.createQuery("select p.id from PrerequisTypeDemande p left join fetch  p.typeDemande left join fetch  p.utilisateur");
			//	+ " where p.typeDemande.id=:x");	
		//req.setParameter("x",id);
		System.out.println(req.getResultList().toString());
		return req.getResultList();
		
		
	}
	
	
}
