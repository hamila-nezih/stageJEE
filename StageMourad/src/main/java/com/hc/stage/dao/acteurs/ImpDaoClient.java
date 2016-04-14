package com.hc.stage.dao.acteurs;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hc.stage.dao.base.GenericJpaDao;
import com.hc.stage.entities.acteurs.Client;

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
