package com.hc.stage.dao.typeDemandes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hc.stage.dao.base.GenericJpaDao;
import com.hc.stage.entities.types.typesDeDemandes.TypeDemande;

public class ImpDaoTypDemande extends GenericJpaDao<TypeDemande, Long> implements InterfaceDaoTypDemande {

	@PersistenceContext
	private EntityManager em;

	public ImpDaoTypDemande() {
		super(TypeDemande.class);
	}

	public ImpDaoTypDemande(Class<TypeDemande> persistentClass) {
		super(persistentClass);
	}


	public TypeDemande getFullTypeDemande(Long id) {

		Query req = em.createQuery("select t from TypeDemande t  "
				+ "  left join fetch   t.prerequisTypeDemandes p left join fetch   t.documentsTypeDemandes"
				+ " where t.id=:x "
				+ "and p.typeDemande.id not in (select histPrq.prerequisDeDemande.id from HistoriquePrerequisDemande histPrq) "
               );
		req.setParameter("x", id);
		if(req.getResultList().size() > 0) 
			return (TypeDemande) req.getResultList().get(0);
		return null;


	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeDemande> getAllTypeDemande() {
		
		Query req = em.createQuery("select t.id, t.titre, t.actif from TypeDemande t");
		return req.getResultList();
	
	}

	
}
