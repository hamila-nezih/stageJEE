package org.hn.stage.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hn.stage.dao.commune.*;
import org.hn.stage.entities.acteurs.Responsable;

public class ImpDaoResponsable extends GenericJpaDao<Responsable, Long> implements InterfaceDaoResponsable{

	@PersistenceContext
	private EntityManager em ;
	
	public ImpDaoResponsable() {
		super(Responsable.class);
	}
	public ImpDaoResponsable(Class<Responsable> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkAvailable(String nom) {
		// TODO Auto-generated method stub
		return false;
	}

}
