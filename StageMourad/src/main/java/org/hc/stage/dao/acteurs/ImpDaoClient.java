package org.hc.stage.dao.acteurs;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hc.stage.dao.base.GenericJpaDao;
import org.hc.stage.entities.acteurs.Client;

public class ImpDaoClient extends GenericJpaDao<Client, Long> implements InterfaceDaoClient{

	@PersistenceContext
	private EntityManager em ;
	
	public ImpDaoClient() {
		super(Client.class);
	}
	public ImpDaoClient(Class<Client> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	}


}
