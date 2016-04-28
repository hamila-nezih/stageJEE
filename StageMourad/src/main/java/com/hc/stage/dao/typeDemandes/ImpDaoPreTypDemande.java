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
		
		//Query req=em.createQuery("select p.id, p.libelle, p.obligatoire, p.typeDemande.id from "
			//	+ "PrerequisTypeDemande p");
		Query req=em.createQuery("select p from "
					+ "PrerequisTypeDemande p where p.libelle=:status");
		
		
		req.setParameter("status","nom");
		return req.getResultList();
     
		
	}
	
	
}
