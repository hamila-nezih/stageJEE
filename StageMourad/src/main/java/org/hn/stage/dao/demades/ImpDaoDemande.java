package org.hn.stage.dao.demades;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hn.stage.dao.base.GenericJpaDao;
import org.hn.stage.entities.demandes.Demande;

public class ImpDaoDemande extends GenericJpaDao<Demande, Long> implements InterfaceDaoDemande{

	@PersistenceContext
	private EntityManager em ;
	
	public ImpDaoDemande() {
		super(Demande.class);
	}
	public ImpDaoDemande(Class<Demande> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	}

}
