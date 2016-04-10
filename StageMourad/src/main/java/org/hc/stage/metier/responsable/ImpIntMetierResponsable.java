package org.hc.stage.metier.responsable;

import org.hc.stage.dao.acteurs.InterfaceDaoResponsable;
import org.hc.stage.dao.acteurs.InterfaceDaoUtilisateur;
import org.hc.stage.dao.historiqueDesTypesDeDemandes.InterfaceDaoHisTypDocument;
import org.hc.stage.dao.historiqueDesTypesDeDemandes.InterfaceDaoHisTypPrerequis;
import org.hc.stage.dao.historiqueDesTypesDeDemandes.InterfaceDaoHistTypDemande;
import org.hc.stage.dao.typeDemandes.InterfaceDaoDocTypDemande;
import org.hc.stage.dao.typeDemandes.InterfaceDaoPreTypDemande;
import org.hc.stage.dao.typeDemandes.InterfaceDaoTypDemande;
import org.hc.stage.entities.acteurs.Utilisateur;
import org.hc.stage.entities.acteurs.Utilisateur;
import org.hc.stage.entities.historisation.historisationDesTypesDeDemandes.HistoriqueTypeDemande;
import org.hc.stage.entities.historisation.historisationDesTypesDeDemandes.HistoriqueTypeDocument;
import org.hc.stage.entities.historisation.historisationDesTypesDeDemandes.HistoriqueTypePrerequis;
import org.hc.stage.entities.types.typesDeDemandes.DocumentTypeDemande;
import org.hc.stage.entities.types.typesDeDemandes.PrerequisTypeDemande;
import org.hc.stage.entities.types.typesDeDemandes.TypeDemande;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class ImpIntMetierResponsable implements InterfaceMetierUtilisateur{

	private InterfaceDaoResponsable daoRes;
	private InterfaceDaoTypDemande daoTyd;
	private InterfaceDaoDocTypDemande daoDTD;
	private InterfaceDaoPreTypDemande daoPTD;
	private InterfaceDaoUtilisateur daoUti;
	private InterfaceDaoHistTypDemande daoHTD;
	private InterfaceDaoHisTypDocument daoHTDoc;
	private InterfaceDaoHisTypPrerequis daoHTP;
	
	public void setDaoHTD(InterfaceDaoHistTypDemande daoHTD) {
		this.daoHTD = daoHTD;
	}
	public void setDaoHTDoc(InterfaceDaoHisTypDocument daoHTDoc) {
		this.daoHTDoc = daoHTDoc;
	}
	public void setDaoHTP(InterfaceDaoHisTypPrerequis daoHTP) {
		this.daoHTP = daoHTP;
	}
	public void setDaoUti(InterfaceDaoUtilisateur daoUti) {
			this.daoUti = daoUti;
		}
    public void setDaoDTD(InterfaceDaoDocTypDemande daoDTD) {
		this.daoDTD = daoDTD;
	}
    public void setDaoPTD(InterfaceDaoPreTypDemande daoPTD) {
  		this.daoPTD = daoPTD;
  	}
	public void setDaoRes(InterfaceDaoResponsable daoRes) {
		this.daoRes = daoRes;
	}
	public void setDaoTyd(InterfaceDaoTypDemande daoTyd) {
		this.daoTyd = daoTyd;
	}
   
	public Long ajouterNouveauTypeDemande(TypeDemande tyD,Utilisateur utilisateur){
		Long idTyD = daoTyd.ajouter(tyD).getId();
	    tyD.setId(idTyD);
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
        //Date date = dateFormat.parse(dateSysteme);
        HistoriqueTypeDemande hTD = new HistoriqueTypeDemande("ajouter",date,null);
        hTD.setResponsable(utilisateur);
        hTD.setTypeDemande(tyD);
	    daoHTD.ajouter(hTD);
	    return idTyD ;
	}
	public Long AjouterNouveauTypeDocumentDemande(DocumentTypeDemande dTD, Utilisateur utilisateur){
		Long idTyDoc = daoDTD.ajouter(dTD).getId();
		dTD.setId(idTyDoc);
		java.util.Date date = new java.util.Date();
		HistoriqueTypeDocument hTDoc = new HistoriqueTypeDocument("ajouter",date,null);
        hTDoc.setResponsable(utilisateur);
        hTDoc.setDocumentTypeDemande(dTD);
	    daoHTDoc.ajouter(hTDoc);
	    return idTyDoc ;
	}
	public Long AjouterNouveauTypePrerequis(PrerequisTypeDemande pTD, Utilisateur utilisateur){
		Long idTyP = daoPTD.ajouter(pTD).getId();
		pTD.setId(idTyP);
		java.util.Date date = new java.util.Date();
		HistoriqueTypePrerequis hTP = new HistoriqueTypePrerequis("ajouter",date,null);
        hTP.setResponsable(utilisateur);
        hTP.setPrerequisTypeDemande(pTD);
	    daoHTP.ajouter(hTP);
	    return idTyP ;
	}
	public Long ajouterNouveauResponsable(Utilisateur res){
		return daoRes.ajouter(res).getId();
	}
	public Long ajouterNouveauUtilisateur(Utilisateur uti){
		return daoUti.ajouter(uti).getId();
	}
	
	

}