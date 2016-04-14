package com.hc.stage.dao.acteurs;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hc.stage.dao.base.GenericJpaDao;
import com.hc.stage.entities.acteurs.Utilisateur;

public class ImpDaoUtilisateur  extends GenericJpaDao<Utilisateur, Long> implements InterfaceDaoUtilisateur{

	@PersistenceContext
	private EntityManager em ;
	
	public ImpDaoUtilisateur() {
		super(Utilisateur.class);
	}
	public ImpDaoUtilisateur(Class<Utilisateur> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	}
	
	
	  
	
	
    


}
