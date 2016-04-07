package org.hn.stage.metier.responsable;

import org.hn.stage.entities.acteurs.Responsable;

public interface InterfaceMetierResponsable  {
	/**
	 * requetes database for Responsable nom valable
	 * 
	 * @param nom
	 * @return true if valable
	 */
	boolean checkAvailable(String nom);
	/**
	 * Create user - persist to database
	 * 
	 * @param userEntity
	 * @return true if success
	 */
	boolean createResponsable(Responsable responsable);
	

}
