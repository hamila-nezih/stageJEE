package org.hn.stage.metier.responsable;

import org.hn.stage.dao.responsable.InterfaceDaoResponsable;
import org.hn.stage.entities.acteurs.Responsable;

public class ImpIntMetierResponsable implements InterfaceMetierResponsable{

	private InterfaceDaoResponsable dao ;

	public void setDao(InterfaceDaoResponsable dao) {
		this.dao = dao;
	}
	@Override
	public boolean checkAvailable(String nom) {
		return false;
	}

	@Override
	public boolean createResponsable(Responsable responsable) {
		dao.save(responsable);
		return false;
	}

}
