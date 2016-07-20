package com.hc.stage.dao.typeDemandes;

import java.util.List;

import com.hc.stage.dao.base.GenericDao;
import com.hc.stage.entities.types.typesDeDemandes.PrerequisTypeDemande;

public interface InterfaceDaoPrerequisTypeDemande extends GenericDao<PrerequisTypeDemande, Long>{
	
	public List<PrerequisTypeDemande> getPrerequisTypeDemande(Long id);
	public void deletePrerequisTypeDemande(Long id);
}
