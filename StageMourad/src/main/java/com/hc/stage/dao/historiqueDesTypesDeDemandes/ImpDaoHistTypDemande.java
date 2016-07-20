package com.hc.stage.dao.historiqueDesTypesDeDemandes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hc.stage.dao.base.GenericJpaDao;
import com.hc.stage.entities.historisation.historisationDesTypesDeDemandes.HistoriqueTypeDemande;

public class ImpDaoHistTypDemande extends GenericJpaDao<HistoriqueTypeDemande, Long> implements InterfaceDaoHistoriqueTypeDemande{

	@PersistenceContext
	private EntityManager em ;
	
	public ImpDaoHistTypDemande() {
		super(HistoriqueTypeDemande.class);
	}
	public ImpDaoHistTypDemande(Class<HistoriqueTypeDemande> persistentClass) {
		super(persistentClass);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HistoriqueTypeDemande> getAllHistoriqueTypeDemande() {
		
		Query req = em.createQuery("select h.typeDemande.libelle, h.typeDemande.titre, h.dateHistorique, h.typeDemande.actif, h.typeDemande.id"
				+ " from HistoriqueTypeDemande h "
	            + " where h.commentaire=:x ");
		req.setParameter("x", "creation");
		
		return req.getResultList();
	}
	@Override
	public void deleteHistoriqueTypeDemande(Long id) {
		Query req = em.createQuery(" delete from HistoriqueTypeDemande h where h.typeDemande.id=:x ");
		req.setParameter("x", id);	
		req.executeUpdate();
	}
	


}
