package org.hn.stage.metier;

import java.util.List;

import org.hn.stage.entities.acteurs.Responsable;
import org.hn.stage.entities.historisationsDesTypes.HistoriqueTypeDemande;
import org.hn.stage.entities.historisationsDesTypes.HistoriqueTypeDocument;
import org.hn.stage.entities.historisationsDesTypes.HistoriqueTypePrerequis;
import org.hn.stage.entities.typeDemandes.DocumentTypeDemande;
import org.hn.stage.entities.typeDemandes.PrerequisTypeDemande;
import org.hn.stage.entities.typeDemandes.TypeDemande;

public interface InterfaceMetierResponsable {
	
	/******************* org.hn.stage.entities.acteurs *******************/
	
	     /******** Responsable  *********/
	
	public Long ajouterResponsable(Responsable r);
	public List<Responsable> listResponsable() ;
	public Responsable getResponsable(Long idResponsable);
	public void supprimerResponsable(Long idResponsable);
	public void modifierResponsable(Responsable r);
	/******************* org.hn.stage.entities.historisationsDesTypes *******************/

	
	/******** HistoriqueTypeDemande  *********/

	public Long ajouterHTD(HistoriqueTypeDemande r, Long idRes, Long idTyD);
	public List<HistoriqueTypeDemande> listHTD() ;
	public HistoriqueTypeDemande getHTD(Long idHTD);
	public void supprimerHTD(Long idHTD);
	public void modifierHTD(HistoriqueTypeDemande r);

	/******** HistoriqueTypeDocument *********/

	public Long ajouterHTDoc(HistoriqueTypeDocument r, Long idRes, Long idDTD);
	public List<HistoriqueTypeDocument> listHTDoc() ;
	public HistoriqueTypeDocument getHTDoc(Long idHTDoc);
	public void supprimerHTDoc(Long idHTDoc);
	public void modifierHTDoc(HistoriqueTypeDocument r);

	/******** HistoriqueTypePrerequis *********/

	public Long ajouterHTP(HistoriqueTypePrerequis r,Long idRes, Long idpTD);
	public List<HistoriqueTypePrerequis> listHTP() ;
	public HistoriqueTypePrerequis getHTP(Long idHTP);
	public void supprimerHTP(Long idHTP);
	public void modifierHTP(HistoriqueTypePrerequis r);
	
	/******************* org.hn.stage.entities.typeDemandes *******************/

	/******** DocumentTypeDemande  *********/

	public Long ajouterDTD(DocumentTypeDemande r);
	public List<DocumentTypeDemande> listDTD() ;
	public DocumentTypeDemande getDTD(Long idDTD);
	public void supprimerDTD(Long idDTD);
	public void modifierDTD(DocumentTypeDemande r);

	/******** PrerequisTypeDemande *********/

	public Long ajouterPTD(PrerequisTypeDemande r);
	public List<PrerequisTypeDemande> listPTD() ;
	public PrerequisTypeDemande getPTD(Long idPTD);
	public void supprimerPTD(Long idPTD);
	public void modifierPTD(PrerequisTypeDemande r);

	/******** TypeDemande *********/

	public Long ajouterTyD(TypeDemande r);	
	public List<TypeDemande> listTyD() ;
	public TypeDemande getTyD(Long idTyD);
	public void supprimerTyD(Long idTyD);
	public void modifierTyD(TypeDemande r);

}
