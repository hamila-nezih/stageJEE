package org.hn.stage.IDao;

import java.util.List;

import javax.persistence.*;

import org.hn.stage.entities.Client;

public class ImpDao implements InterfaceDao{
	@PersistenceContext
	private EntityManager em ;


	@Override
	public Long ajouterClient(Client c) {
		em.persist(c);
		return c.getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> listClient() {
        Query req=em.createQuery("select c from Client c");
        return req.getResultList();
	}

	@Override
	public Client getClient(Long idClient) {
		return em.find(Client.class, idClient);
	}

	@Override
	public void supprimerClient(Long idClient) {
		Client c=  em.find(Client.class, idClient);
		 em.remove(c);

		
	}

	@Override
	public void modifierClient(Client c) {
		em.merge(c);		
	}

}
