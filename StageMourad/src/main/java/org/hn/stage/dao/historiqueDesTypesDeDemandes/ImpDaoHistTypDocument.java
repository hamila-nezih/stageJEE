package org.hn.stage.dao.historiqueDesTypesDeDemandes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hn.stage.dao.base.GenericJpaDao;
import org.hn.stage.entities.historisationsDesTypesDeDemandes.HistoriqueTypeDocument;

public class ImpDaoHistTypDocument extends GenericJpaDao<HistoriqueTypeDocument, Long> implements InterfaceDaoHisTypDocument{

	@PersistenceContext
	private EntityManager em ;
	
	public ImpDaoHistTypDocument() {
		super(HistoriqueTypeDocument.class);
	}
	public ImpDaoHistTypDocument(Class<HistoriqueTypeDocument> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	} 

}
