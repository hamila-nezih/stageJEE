package com.hc.stage.dao.typeDemandes;

import com.hc.stage.dao.base.GenericDao;
import com.hc.stage.entities.types.typesDeDemandes.TypeDemande;

public interface InterfaceDaoTypDemande extends GenericDao<TypeDemande, Long> {

	public TypeDemande getFullTypeDemande(Long id);
}
