package org.hn.stage.metier.responsable;

import org.hn.stage.dao.acteurs.InterfaceDaoResponsable;
import org.hn.stage.dao.acteurs.InterfaceDaoUtilisateur;
import org.hn.stage.dao.historiqueDesTypesDeDemandes.InterfaceDaoHisTypDocument;
import org.hn.stage.dao.historiqueDesTypesDeDemandes.InterfaceDaoHisTypPrerequis;
import org.hn.stage.dao.historiqueDesTypesDeDemandes.InterfaceDaoHistTypDemande;
import org.hn.stage.dao.typeDemandes.InterfaceDaoDocTypDemande;
import org.hn.stage.dao.typeDemandes.InterfaceDaoPreTypDemande;
import org.hn.stage.dao.typeDemandes.InterfaceDaoTypDemande;
import org.hn.stage.entities.acteurs.Responsable;
import org.hn.stage.entities.acteurs.Utilisateur;
import org.hn.stage.entities.historisationsDesTypesDeDemandes.HistoriqueTypeDemande;
import org.hn.stage.entities.historisationsDesTypesDeDemandes.HistoriqueTypeDocument;
import org.hn.stage.entities.historisationsDesTypesDeDemandes.HistoriqueTypePrerequis;
import org.hn.stage.entities.typeDemandes.DocumentTypeDemande;
import org.hn.stage.entities.typeDemandes.PrerequisTypeDemande;
import org.hn.stage.entities.typeDemandes.TypeDemande;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class ImpIntMetierResponsable implements InterfaceMetierResponsable{

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
   
	public Long ajouterNouveauTypeDemande(TypeDemande tyD,Responsable responsable){
		Long idTyD = daoTyd.ajouter(tyD).getId();
	    tyD.setId(idTyD);
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
        //Date date = dateFormat.parse(dateSysteme);
        HistoriqueTypeDemande hTD = new HistoriqueTypeDemande("ajouter",date,null);
        hTD.setResponsable(responsable);
        hTD.setTypeDemande(tyD);
	    daoHTD.ajouter(hTD);
	    return idTyD ;
	}
	public Long AjouterNouveauTypeDocumentDemande(DocumentTypeDemande dTD, Responsable responsable){
		Long idTyDoc = daoDTD.ajouter(dTD).getId();
		dTD.setId(idTyDoc);
		java.util.Date date = new java.util.Date();
		HistoriqueTypeDocument hTDoc = new HistoriqueTypeDocument("ajouter",date,null);
        hTDoc.setResponsable(responsable);
        hTDoc.setDocumentTypeDemande(dTD);
	    daoHTDoc.ajouter(hTDoc);
	    return idTyDoc ;
	}
	public Long AjouterNouveauTypePrerequis(PrerequisTypeDemande pTD, Responsable responsable){
		Long idTyP = daoPTD.ajouter(pTD).getId();
		pTD.setId(idTyP);
		java.util.Date date = new java.util.Date();
		HistoriqueTypePrerequis hTP = new HistoriqueTypePrerequis("ajouter",date,null);
        hTP.setResponsable(responsable);
        hTP.setPrerequisTypeDemande(pTD);
	    daoHTP.ajouter(hTP);
	    return idTyP ;
	}
	public Long ajouterNouveauResponsable(Responsable res){
		return daoRes.ajouter(res).getId();
	}
	public Long ajouterNouveauUtilisateur(Utilisateur uti){
		return daoUti.ajouter(uti).getId();
	}
	
	

}
