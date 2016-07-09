package com.hc.stage.dao.acteurs;

import java.util.List;

import com.hc.stage.dao.base.GenericDao;
import com.hc.stage.entities.acteurs.Client;

public interface InterfaceDaoClient extends GenericDao<Client, Long>{
	
	public List<Client> connexion(String login, String password);

}
