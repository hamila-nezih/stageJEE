package org.hn.stage.Mitier;

import java.util.List;

import org.hn.stage.entities.Client;

public interface InterfaceMetier {
	public Long ajouterClient(Client c);
	public List<Client> listClient() ;
	public Client getClient(Long idClient);
	public void supprimerClient(Long idClient);
	public void modifierClient(Client c);
	

}
