package org.hc.stage.dao.demades;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hc.stage.dao.base.GenericJpaDao;
import org.hc.stage.entities.demandes.DocumentDeDemande;

public class ImpDaoDocumentDemande extends GenericJpaDao<DocumentDeDemande, Long> implements InterfaceDaoDocumentDemande{

	@PersistenceContext
	private EntityManager em ;
	
	public ImpDaoDocumentDemande() {
		super(DocumentDeDemande.class);
	}
	public ImpDaoDocumentDemande(Class<DocumentDeDemande> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	} 

}
