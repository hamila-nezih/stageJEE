package org.hn.stage.metier;



import java.util.List;

import org.hn.stage.dao.InterfaceDao;
import org.hn.stage.entities.acteurs.*;

import org.hn.stage.entities.historisationsDesTypes.*;

import org.hn.stage.entities.typeDemandes.*;

import org.springframework.transaction.annotation.Transactional;
@Transactional
public class ImpIntMetierResponsable implements InterfaceMetierResponsable{
	
	private InterfaceDao dao ;

	public void setDao(InterfaceDao dao) {
		this.dao = dao;
	}

	/******************* InterfaceMetierResponsable *******************/
	
    /******** Responsable  *********/

	public Long ajouterResponsable(Responsable r){
		return dao.ajouterResponsable(r);	
	}
	public List<Responsable> listResponsable(){
		return dao.listResponsable();	
	}
	public Responsable getResponsable(Long idResponsable){
		return dao.getResponsable(idResponsable);	
	}
	public void supprimerResponsable(Long idResponsable){
		 dao.supprimerResponsable(idResponsable);	
	}
	public void modifierResponsable(Responsable r){
		 dao.modifierResponsable(r);	
	}
	/******************* org.hn.stage.entities.historisationsDesTypes *******************/
	
	/******** HistoriqueTypeDemande  *********/

	public Long ajouterHTD(HistoriqueTypeDemande r, Long idRes, Long idTyD){
		 return dao.ajouterHTD(r, idRes, idTyD);	
	}
	public List<HistoriqueTypeDemande> listHTD() {
		return dao.listHTD();	
	}
	public HistoriqueTypeDemande getHTD(Long idHTD){
		return  dao.getHTD(idHTD);	
	}
	public void supprimerHTD(Long idHTD){
		 dao.supprimerHTD(idHTD);	
	}
	public void modifierHTD(HistoriqueTypeDemande r){
		 dao.modifierHTD(r);	
	}

	/******** HistoriqueTypeDocument *********/

	public Long ajouterHTDoc(HistoriqueTypeDocument r, Long idRes, Long idDTD){
		 return dao.ajouterHTDoc(r,idRes ,idDTD);	
	}
	public List<HistoriqueTypeDocument> listHTDoc() {
		 return dao.listHTDoc();	
	}
	public HistoriqueTypeDocument getHTDoc(Long idHTDoc){
		 return dao.getHTDoc(idHTDoc);	
	}
	public void supprimerHTDoc(Long idHTDoc){
		 dao.supprimerHTDoc(idHTDoc);	
	}
	public void modifierHTDoc(HistoriqueTypeDocument r){
		 dao.modifierHTDoc(r);	
	}

	/******** HistoriqueTypePrerequis *********/

	public Long ajouterHTP(HistoriqueTypePrerequis r,Long idRes, Long idpTD){
		 return dao.ajouterHTP(r, idRes, idpTD);	
	}
	public List<HistoriqueTypePrerequis> listHTP() {
		 return dao.listHTP();	
	}
	public HistoriqueTypePrerequis getHTP(Long idHTP){
		 return dao.getHTP(idHTP);	
	}
	public void supprimerHTP(Long idHTP){
		 dao.supprimerHTP(idHTP);	
	}
	public void modifierHTP(HistoriqueTypePrerequis r){
		 dao.modifierHTP(r);	
	}

/******************* org.hn.stage.entities.typeDemandes *******************/

	/******** DocumentTypeDemande  *********/

	public Long ajouterDTD(DocumentTypeDemande r){
		 return dao.ajouterDTD(r);	
	}
	public List<DocumentTypeDemande> listDTD() {
		 return dao.listDTD();	
	}
	public DocumentTypeDemande getDTD(Long idDTD){
		 return dao.getDTD(idDTD);	
	}
	public void supprimerDTD(Long idDTD){
		 dao.supprimerDTD(idDTD);	
	}
	public void modifierDTD(DocumentTypeDemande r){
		 dao.modifierDTD(r);	
	}

/******** PrerequisTypeDemande *********/

	public Long ajouterPTD(PrerequisTypeDemande r){
		 return dao.ajouterPTD(r);	
	}
	public List<PrerequisTypeDemande> listPTD(){
		 return dao.listPTD();	
	}
	public PrerequisTypeDemande getPTD(Long idPTD){
		 return dao.getPTD(idPTD);	
	}
	public void supprimerPTD(Long idPTD){
		 dao.supprimerPTD(idPTD);	
	}
	public void modifierPTD(PrerequisTypeDemande r){
		 dao.modifierPTD(r);	
	}

/******** TypeDemande *********/

	public Long ajouterTyD(TypeDemande r){
		 return dao.ajouterTyD(r);	
	}
	public List<TypeDemande> listTyD(){
		 return dao.listTyD();	
	}
	public TypeDemande getTyD(Long idTyD){
		 return dao.getTyD(idTyD);	
	}
	public void supprimerTyD(Long idTyD){
		 dao.supprimerTyD(idTyD);	
	}
	public void modifierTyD(TypeDemande r){
		 dao.modifierTyD(r);	
	}

	
	
	
	
	

}
