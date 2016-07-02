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
				+ " , p.prerequisTypeDemande.tybeVariable,p.prerequisTypeDemande.ordre ,p.prerequisTypeDemande.id"
				+ "  from PrerequisDeDemande p  "
				+ " where p.demande.id=:x and "
				+ "p.id not in (select histPrq.prerequisDeDemande.id from HistoriquePrerequisDemande histPrq) "
				+ "order by  p.prerequisTypeDemande.ordre");
		req.setParameter("x", idDmd);
		return  req.getResultList();

		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PrerequisDeDemande>  getPrerequisHist(Long idDmd) {
		Query req = em.createQuery("select p.libelle, p.prerequisTypeDemande.libelle"
				+ " , p.dateCreation"
				+ "  from PrerequisDeDemande p  "
				+ " where p.demande.id=:x "
				+ "order by  p.prerequisTypeDemande.ordre");
		req.setParameter("x", idDmd);
		return  req.getResultList();
	}
	
	

}
