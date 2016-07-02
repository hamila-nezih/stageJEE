package com.hc.stage.dao.demades;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hc.stage.dao.base.GenericJpaDao;
import com.hc.stage.entities.demandes.DocumentDeDemande;

public class ImpDaoDocumentDemande extends GenericJpaDao<DocumentDeDemande, Long>
		implements InterfaceDaoDocumentDemande {

	@PersistenceContext
	private EntityManager em;

	public ImpDaoDocumentDemande() {
		super(DocumentDeDemande.class);
	}

	public ImpDaoDocumentDemande(Class<DocumentDeDemande> persistentClass) {
		super(persistentClass);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentDeDemande> getDocument(Long idDmd) {
		Query req = em.createQuery("select d.id, d.libelle, d.documentTypeDemandes.libelle,d.nomFichier"
				+ " , d.documentTypeDemandes.obligatoire, d.documentTypeDemandes.ordre , d.documentTypeDemandes.id "
				+ "  from DocumentDeDemande d  " + " where d.demande.id=:x and "
				+ "d.id not in (select histDoc.documentDeDemande.id from HistoriqueDocumentDemande histDoc) "
				+ "order by  d.documentTypeDemandes.ordre");
		req.setParameter("x", idDmd);
		return req.getResultList();
		// return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentDeDemande> getDocumentHist(Long idDmd) {
		Query req = em.createQuery("select  d.documentTypeDemandes.libelle, d.nomFichier, d.dateCreation, d.id" 
	            + "  from DocumentDeDemande d  "
				+ " where d.demande.id=:x "
				+ "order by  d.documentTypeDemandes.ordre");
		req.setParameter("x", idDmd);
		return req.getResultList();

	}

}
