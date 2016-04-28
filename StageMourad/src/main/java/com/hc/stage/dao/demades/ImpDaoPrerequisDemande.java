package com.hc.stage.dao.demades;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hc.stage.dao.base.GenericJpaDao;
import com.hc.stage.entities.demandes.PrerequisDeDemande;

public class ImpDaoPrerequisDemande  extends GenericJpaDao<PrerequisDeDemande, Long> implements InterfaceDaoPrerequisDemande{

	@PersistenceContext
	private EntityManager em ;
	
	public ImpDaoPrerequisDemande() {
		super(PrerequisDeDemande.class);
	}
	public ImpDaoPrerequisDemande(Class<PrerequisDeDemande> persistentClass) {
		super(persistentClass);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PrerequisDeDemande> getPrerequisDemande(Long id){

        Query req=em.createQuery("select p from PrerequisDeDemande p");
        //req.setParameter("x",id);
		
		return req.getResultList();
	}
	
	

}
