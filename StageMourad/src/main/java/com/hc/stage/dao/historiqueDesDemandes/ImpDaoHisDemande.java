package com.hc.stage.dao.historiqueDesDemandes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hc.stage.dao.base.GenericJpaDao;
import com.hc.stage.entities.historisation.historisationDesDemandes.HistoriqueDemande;

public class ImpDaoHisDemande extends GenericJpaDao<HistoriqueDemande, Long> implements InterfaceDaoHisDemande{

	@PersistenceContext
	private EntityManager em ;
	
	public ImpDaoHisDemande() {
		super(HistoriqueDemande.class);
	}
	public ImpDaoHisDemande(Class<HistoriqueDemande> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<HistoriqueDemande> getDemandeHistoriqueEncours(Long id) {
		Query req = em.createQuery("select d.typeHist, d.dateHist"
                + " from HistoriqueDemande d  "
                + " where d.demande.id=:x");
               req.setParameter("x", id);
         return req.getResultList();
	}


}
