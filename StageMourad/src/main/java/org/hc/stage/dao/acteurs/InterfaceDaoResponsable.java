package org.hc.stage.dao.acteurs;

import org.hc.stage.dao.base.GenericDao;
import org.hc.stage.entities.acteurs.Utilisateur;

public interface InterfaceDaoResponsable extends GenericDao<Utilisateur, Long> {
	/**
	 * requetes database for Responsable nom valable
	 * 
	 * @param nom
	 * @return true if valable
	 */
	boolean checkAvailable(String nom);

}
