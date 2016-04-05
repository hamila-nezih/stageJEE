package org.hn.stage.Mitier;



import java.util.List;

import org.hn.stage.IDao.InterfaceDao;
import org.hn.stage.entities.Client;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class ImpIntMetier implements InterfaceMetier{
	
	private InterfaceDao dao ;

	public void setDao(InterfaceDao dao) {
		this.dao = dao;
	}

	@Override
	public Long ajouterClient(Client c) {
		
		return dao.ajouterClient(c);
	}

	@Override
	public List<Client> listClient() {
		return dao.listClient();
	}

	@Override
	public Client getClient(Long idClient) {
		return dao.getClient(idClient);
	}

	@Override
	public void supprimerClient(Long idClient) {
		dao.supprimerClient(idClient);
		
	}

	@Override
	public void modifierClient(Client c) {
		dao.modifierClient(c);		
	}

	
}
