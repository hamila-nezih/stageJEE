package com.hc.stage.dao.demades;

import java.util.List;

import com.hc.stage.dao.base.GenericDao;
import com.hc.stage.entities.demandes.PrerequisDeDemande;

public interface InterfaceDaoPrerequisDemande extends GenericDao<PrerequisDeDemande, Long>{
	
	 public List<PrerequisDeDemande> getPrerequisDemande(Long id);
	 public  List<PrerequisDeDemande>  getPrerequis(Long idDmd);
	

}
