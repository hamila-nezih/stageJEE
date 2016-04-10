package org.hc.stage.dao.acteurs;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hc.stage.dao.base.*;
import org.hc.stage.entities.acteurs.Utilisateur;

public class ImpDaoResponsable extends GenericJpaDao<Utilisateur, Long> implements InterfaceDaoResponsable{

	@PersistenceContext
	private EntityManager em ;
	
	public ImpDaoResponsable() {
		super(Utilisateur.class);
	}
	public ImpDaoResponsable(Class<Utilisateur> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkAvailable(String nom) {
		// TODO Auto-generated method stub
		return false;
	}

}
