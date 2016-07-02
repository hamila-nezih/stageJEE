package com.hc.stage.dao.demades;

import java.util.List;

import com.hc.stage.dao.base.GenericDao;
import com.hc.stage.entities.demandes.DocumentDeDemande;

public interface InterfaceDaoDocumentDemande extends GenericDao<DocumentDeDemande, Long> {
	
	 public  List<DocumentDeDemande>  getDocument(Long idDmd);

	List<DocumentDeDemande> getDocumentHist(Long idDmd);

}
