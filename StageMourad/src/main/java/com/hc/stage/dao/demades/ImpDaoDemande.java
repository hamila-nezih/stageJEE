package com.hc.stage.dao.demades;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hc.stage.dao.base.GenericJpaDao;
import com.hc.stage.entities.demandes.Demande;
import com.hc.stage.entities.types.typesDeDemandes.TypeDemande;

public class ImpDaoDemande extends GenericJpaDao<Demande, Long> implements InterfaceDaoDemande{

	@PersistenceContext
	private EntityManager em ;
	
	public ImpDaoDemande() {
		super(Demande.class);
	}
	public ImpDaoDemande(Class<Demande> persistentClass) {
		super(persistentClass);		
	}
	
	@SuppressWarnings("unchecked")
	public List<Demande> getDemandes(Long idC){
		Query req = em.createQuery("select d.typeDemande.titre, d.etat, d.dateCreation, d.id  from Demande d  "
				+ " where d.client.id=:x and "
				+ "(d.etat='En cours de traitement' or d.etat='En attente' or d.etat='Information(s) manquante(s)')");
		req.setParameter("x", idC);
		return req.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Demande> getDemandesCloture(Long idC){
		Query req = em.createQuery("select d.typeDemande.titre, d.etat, d.dateCreation, d.id, d.dateModification"
				+ " from Demande d  "
				+ " where d.client.id=:x and "
				+ "(d.etat='Accepter' or d.etat='Refuser' or d.etat='Annuler')");
		req.setParameter("x", idC);
		return req.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Demande> getDemandeHistorique(Long idDemande){
		Query req = em.createQuery("select d.typeDemande.titre, d.etat, d.dateCreation, d.dateModification, d.commentaire"
				+ " from Demande d  "
				+ " where d.id=:x");
		req.setParameter("x", idDemande);
		return req.getResultList();
	}
	

}
