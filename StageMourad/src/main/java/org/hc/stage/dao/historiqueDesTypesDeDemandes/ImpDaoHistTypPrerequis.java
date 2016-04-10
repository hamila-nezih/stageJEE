package org.hc.stage.dao.historiqueDesTypesDeDemandes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hc.stage.dao.base.GenericJpaDao;
import org.hc.stage.entities.historisation.historisationDesTypesDeDemandes.HistoriqueTypePrerequis;

public class ImpDaoHistTypPrerequis  extends GenericJpaDao<HistoriqueTypePrerequis, Long> implements InterfaceDaoHisTypPrerequis{

	@PersistenceContext
	private EntityManager em ;
	
	public ImpDaoHistTypPrerequis() {
		super(HistoriqueTypePrerequis.class);
	}
	public ImpDaoHistTypPrerequis(Class<HistoriqueTypePrerequis> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	} 
}
