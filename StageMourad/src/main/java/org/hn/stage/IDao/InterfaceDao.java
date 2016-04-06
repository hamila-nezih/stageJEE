package org.hn.stage.IDao;

import java.util.List;

import org.hn.stage.entities.*;

public interface InterfaceDao {
	
	public Long ajouterClient(Client c);
	public List<Client> listClient() ;
	public Client getClient(Long idClient);
	public void supprimerClient(Long idClient);
	public void modifierClient(Client c);
	
	
	
}
