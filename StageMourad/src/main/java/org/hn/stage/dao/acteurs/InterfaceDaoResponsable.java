package org.hn.stage.dao.acteurs;

import org.hn.stage.dao.base.GenericDao;
import org.hn.stage.entities.acteurs.Responsable;

public interface InterfaceDaoResponsable extends GenericDao<Responsable, Long> {
	/**
	 * requetes database for Responsable nom valable
	 * 
	 * @param nom
	 * @return true if valable
	 */
	boolean checkAvailable(String nom);

}
