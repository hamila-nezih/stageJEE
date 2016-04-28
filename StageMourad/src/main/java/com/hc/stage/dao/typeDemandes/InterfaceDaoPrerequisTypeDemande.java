package com.hc.stage.dao.typeDemandes;

import java.util.List;

import com.hc.stage.dao.base.GenericDao;
import com.hc.stage.entities.types.typesDeDemandes.PrerequisTypeDemande;

public interface InterfaceDaoPrerequisTypeDemande extends GenericDao<PrerequisTypeDemande, Long>{
	
	 List<PrerequisTypeDemande> getPrerequisTypeDemande(Long id);

}
