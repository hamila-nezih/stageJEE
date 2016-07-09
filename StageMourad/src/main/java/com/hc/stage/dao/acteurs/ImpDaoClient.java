package com.hc.stage.dao.acteurs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hc.stage.dao.base.GenericJpaDao;
import com.hc.stage.entities.acteurs.Client;
import com.hc.stage.entities.demandes.Demande;

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
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> connexion(String login, String password) {
		
			Query req = em.createQuery("select c from Client c  "
					+ " where c.mail=:x and c.motsPasse=:y ");
					req.setParameter("x", login);
					req.setParameter("y", password);
			if(req.getResultList().size() > 0)
				return req.getResultList();	
			return null;
	}
	
	

}
