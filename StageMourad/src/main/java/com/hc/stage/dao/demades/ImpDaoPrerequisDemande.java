package com.hc.stage.dao.demades;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hc.stage.dao.base.GenericJpaDao;
import com.hc.stage.entities.demandes.PrerequisDeDemande;
import com.hc.stage.entities.types.typesDeDemandes.TypeDemande;

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
		return req.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PrerequisDeDemande>  getPrerequis(Long idDmd) {
		Query req = em.createQuery("select p.id, p.libelle, p.prerequisTypeDemande.libelle, p.prerequisTypeDemande.obligatoire"
				+ " , p.prerequisTypeDemande.tybeVariable,p.prerequisTypeDemande.ordre "
				+ "  from PrerequisDeDemande p  "
				+ " where p.demande.id=:x order by  p.prerequisTypeDemande.ordre");
		req.setParameter("x", idDmd);
		System.out.println(req.getResultList().get(0));
		return  req.getResultList();

		
	}
	
	

}
