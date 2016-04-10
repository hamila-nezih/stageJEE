package org.hn.stage.dao.demades;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hn.stage.dao.base.GenericJpaDao;
import org.hn.stage.entities.demandes.DocumentDemande;

public class ImpDaoDocumentDemande extends GenericJpaDao<DocumentDemande, Long> implements InterfaceDaoDocumentDemande{

	@PersistenceContext
	private EntityManager em ;
	
	public ImpDaoDocumentDemande() {
		super(DocumentDemande.class);
	}
	public ImpDaoDocumentDemande(Class<DocumentDemande> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	} 

}
