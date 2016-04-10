package org.hn.stage.dao.historiqueDesTypesDeDemandes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hn.stage.dao.base.GenericJpaDao;
import org.hn.stage.entities.historisationsDesTypesDeDemandes.HistoriqueTypePrerequis;

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
