package org.hn.stage.dao;

import java.util.List;

import javax.persistence.*;

import org.hn.stage.entities.acteurs.Client;
import org.hn.stage.entities.acteurs.Responsable;
import org.hn.stage.entities.acteurs.Utilisateur;
import org.hn.stage.entities.demandes.Demande;
import org.hn.stage.entities.demandes.DocumentDemande;
import org.hn.stage.entities.demandes.PrerequisDemande;
import org.hn.stage.entities.historisationsDesDemandes.HistoriqueDemande;
import org.hn.stage.entities.historisationsDesDemandes.HistoriqueDocumentDemande;
import org.hn.stage.entities.historisationsDesDemandes.HistoriquePrerequisDemande;
import org.hn.stage.entities.historisationsDesDemandes.HistoriqueServiceDemande;
import org.hn.stage.entities.historisationsDesTypesDeDemandes.HistoriqueTypeDemande;
import org.hn.stage.entities.historisationsDesTypesDeDemandes.HistoriqueTypeDocument;
import org.hn.stage.entities.historisationsDesTypesDeDemandes.HistoriqueTypePrerequis;
import org.hn.stage.entities.typeDemandes.DocumentTypeDemande;
import org.hn.stage.entities.typeDemandes.PrerequisTypeDemande;
import org.hn.stage.entities.typeDemandes.TypeDemande;

public class ImpDao implements InterfaceDao{
	@PersistenceContext
	private EntityManager em ;
	/******************* org.hn.stage.entities.acteurs *******************/
	
				/******** Client  *********/
	@Override
	public Long ajouterClient(Client c) {
		em.persist(c);
		return c.getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> listClient() {
        Query req=em.createQuery("select c from Client c");
        return req.getResultList();
	}

	@Override
	public Client getClient(Long idClient) {
		return em.find(Client.class, idClient);
	}

	@Override
	public void supprimerClient(Long idClient) {
		Client c=  em.find(Client.class, idClient);
		 em.remove(c);

		
	}

	@Override
	public void modifierClient(Client c) {
		em.merge(c);		
	}
	
				/************ Responsable ********************/

	@Override
	public Long ajouterResponsable(Responsable r) {
		em.persist(r);
		return r.getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Responsable> listResponsable() {
		Query req=em.createQuery("select c from Responsable c");
        return req.getResultList();
	}

	@Override
	public Responsable getResponsable(Long idResponsable) {
		return em.find(Responsable.class, idResponsable);
	}

	@Override
	public void supprimerResponsable(Long idResponsable) {
		Responsable c=  em.find(Responsable.class, idResponsable);
		 em.remove(c);
		
	}

	@Override
	public void modifierResponsable(Responsable r) {
		em.merge(r);	
		
	}
   
				/************* Service  ***************/
	
	@Override
	public Long ajouterService(Utilisateur r) {
		em.persist(r);
		return r.getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> listService() {
		Query req=em.createQuery("select c from Service c");
        return req.getResultList();
	}

	@Override
	public Utilisateur getService(Long idService) {
		return em.find(Utilisateur.class, idService);
	}

	@Override
	public void supprimerService(Long idService) {
		Utilisateur c=  em.find(Utilisateur.class, idService);
		 em.remove(c);
		
	}

	@Override
	public void modifierService(Utilisateur r) {
		em.merge(r);	
		
	}
	
	/******************* org.hn.stage.entities.historisationsDesTypes *******************/
	
	
				/******** HistoriqueTypeDemande  *********/
	
	@Override
	public Long ajouterHTD(HistoriqueTypeDemande r, Long idRes, Long idTyD) {
		Responsable responsable = getResponsable(idRes);
		TypeDemande typeDemande = getTyD(idTyD);
		r.setResponsable(responsable);
		r.setTypeDemande(typeDemande);
		em.persist(r);
		return r.getId();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<HistoriqueTypeDemande> listHTD() {
		Query req=em.createQuery("select c from HistoriqueTypePrerequis c");
        return req.getResultList();
	}

	@Override
	public HistoriqueTypeDemande getHTD(Long idHTD) {
		return em.find(HistoriqueTypeDemande.class, idHTD);
	}

	@Override
	public void supprimerHTD(Long idHTD) {
		HistoriqueTypeDemande c=  em.find(HistoriqueTypeDemande.class, idHTD);
		 em.remove(c);
		
	}

	@Override
	public void modifierHTD(HistoriqueTypeDemande r) {
		em.merge(r);	
		
	}

				/******** HistoriqueTypeDocument  *********/
	
	@Override
	public Long ajouterHTDoc(HistoriqueTypeDocument r, Long idRes, Long idDTD) {
		Responsable responsable = getResponsable(idRes);
		DocumentTypeDemande documentTypeDemande = getDTD(idDTD);
		r.setResponsable(responsable);
		r.setDocumentTypeDemande(documentTypeDemande);
		em.persist(r);
		return r.getId();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<HistoriqueTypeDocument> listHTDoc() {
		Query req=em.createQuery("select c from HistoriqueTypePrerequis c");
        return req.getResultList();
	}

	@Override
	public HistoriqueTypeDocument getHTDoc(Long idHTDoc) {
		return em.find(HistoriqueTypeDocument.class, idHTDoc);
	}

	@Override
	public void supprimerHTDoc(Long idHTDoc) {
		HistoriqueTypeDocument c=  em.find(HistoriqueTypeDocument.class, idHTDoc);
		 em.remove(c);
		
	}

	@Override
	public void modifierHTDoc(HistoriqueTypeDocument r) {
		em.merge(r);	
		
	}		
	
							/******** HistoriqueTypePrerequis  *********/
	
	@Override
	public Long ajouterHTP(HistoriqueTypePrerequis r, Long idRes, Long idpTD) {
		Responsable responsable = getResponsable(idRes);
		PrerequisTypeDemande prerequisTypeDemande = getPTD(idpTD);
		r.setResponsable(responsable);
		r.setPrerequisTypeDemande(prerequisTypeDemande);
		em.persist(r);
		return r.getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistoriqueTypePrerequis> listHTP() {
		Query req=em.createQuery("select c from HistoriqueTypePrerequis c");
        return req.getResultList();
	}

	@Override
	public HistoriqueTypePrerequis getHTP(Long idHTP) {
		return em.find(HistoriqueTypePrerequis.class, idHTP);
	}

	@Override
	public void supprimerHTP(Long idHTP) {
		HistoriqueTypePrerequis c=  em.find(HistoriqueTypePrerequis.class, idHTP);
		 em.remove(c);
		
	}

	@Override
	public void modifierHTP(HistoriqueTypePrerequis r) {
		em.merge(r);	
		
	}
	
			
	
	/******************* org.hn.stage.entities.demandes *******************/
	
	
	/******** Demande  *********/

	@Override
	public Long ajouterDmd(Demande r) {
		em.persist(r);
		return r.getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Demande> listDmd() {
		Query req=em.createQuery("select c from Demande c");
		return req.getResultList();
	}

	@Override
	public Demande getDmd(Long idDmd) {
		return em.find(Demande.class, idDmd);
	}

	@Override
	public void supprimerDmd(Long idDmd) {
		Demande c=  em.find(Demande.class, idDmd);
		em.remove(c);

	}

	@Override
	public void modifierDmd(Demande r) {
		em.merge(r);	

	}

							/******** DocumentDemande  *********/

	@Override
	public Long ajouterDoD(DocumentDemande r) {
		em.persist(r);
		return r.getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentDemande> listDoD() {
		Query req=em.createQuery("select c from DocumentDemande c");
		return req.getResultList();
	}

	@Override
	public DocumentDemande getDoD(Long idDoD) {
		return em.find(DocumentDemande.class, idDoD);
	}

	@Override
	public void supprimerDoD(Long idDoD) {
		DocumentDemande c=  em.find(DocumentDemande.class, idDoD);
		em.remove(c);
	}

	@Override
	public void modifierDoD(DocumentDemande r) {
		em.merge(r);	
	}		

				/******** PrerequisDemande  *********/

	@Override
	public Long ajouterPrD(PrerequisDemande r) {
		em.persist(r);
		return r.getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PrerequisDemande> listPrD() {
		Query req=em.createQuery("select c from PrerequisDemande c");
		return req.getResultList();
	}

	@Override
	public PrerequisDemande getPrD(Long idPrD) {
		return em.find(PrerequisDemande.class, idPrD);	
	}

	@Override
	public void supprimerPrD(Long idPrD) {
		PrerequisDemande c=  em.find(PrerequisDemande.class, idPrD);
		em.remove(c);

	}

	@Override
	public void modifierPrD(PrerequisDemande r) {
		em.merge(r);	

	}
	/******************* org.hn.stage.entities.typeDemandes *******************/

	/******** TypeDemande *********/
	@Override
	public Long ajouterTyD(TypeDemande r ){
		em.persist(r);
		return r.getId();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<TypeDemande> listTyD()  {
		Query req=em.createQuery("select c from TypeDemande c");
		return req.getResultList();
	}
	public TypeDemande getTyD(Long idTyD) {
		return em.find(TypeDemande.class, idTyD);	
	}
	@Override
	public void supprimerTyD(Long idTyD){
		PrerequisDemande c=  em.find(PrerequisDemande.class, idTyD);
		em.remove(c);
		}
	@Override
	public void modifierTyD(TypeDemande r){
		em.merge(r);
		}
	/******** DocumentTypeDemande  *********/

	@Override
	public Long ajouterDTD(DocumentTypeDemande r){
		em.persist(r);
		return r.getId();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentTypeDemande> listDTD()  {
		Query req=em.createQuery("select c from DocumentTypeDemande c");
		return req.getResultList();
	}
	@Override
	public DocumentTypeDemande getDTD(Long idDTD) {
		return em.find(DocumentTypeDemande.class, idDTD);	
	}
	@Override
	public void supprimerDTD(Long idDTD){
		PrerequisDemande c=  em.find(PrerequisDemande.class, idDTD);
		em.remove(c);
	}
	@Override
	public void modifierDTD(DocumentTypeDemande r){
		em.merge(r);	
	}

				/******** PrerequisTypeDemande *********/
	@Override
	public Long ajouterPTD(PrerequisTypeDemande r){
		em.persist(r);
		return r.getId();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PrerequisTypeDemande> listPTD()  {
		Query req=em.createQuery("select c from PrerequisTypeDemande c");
		return req.getResultList();
	}
	@Override
	public PrerequisTypeDemande getPTD(Long idPTD) {
		return em.find(PrerequisTypeDemande.class, idPTD);	
	}
	@Override
	public void supprimerPTD(Long idPTD){
		PrerequisDemande c=  em.find(PrerequisDemande.class, idPTD);
		em.remove(c);
	}
	@Override
	public void modifierPTD(PrerequisTypeDemande r){
		em.merge(r);	

	}

	
/******************* org.hn.stage.entities.historisationsDesDemandes *******************/

	/******** HistoriqueDemande *********/
	@Override
	public Long ajouterHDm(HistoriqueDemande r){
		em.persist(r);
		return r.getId();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<HistoriqueDemande> listHDm()  {
		Query req=em.createQuery("select c from HistoriqueDemande c");
		return req.getResultList();
	}
	@Override
	public HistoriqueDemande getHDm(Long idHDm) {
		return em.find(HistoriqueDemande.class, idHDm);	
	}
	@Override
	public void supprimerHDm(Long idHDm){
		HistoriqueDemande c=  em.find(HistoriqueDemande.class, idHDm);
		em.remove(c);
		}
	@Override
	public void modifierHDm(HistoriqueDemande r){
		em.merge(r);	
		}
	
	/******** HistoriqueDocumentDemande  *********/

	public Long ajouterHDD(HistoriqueDocumentDemande r){
		em.persist(r);
		return r.getId();
	}
	@SuppressWarnings("unchecked")
	public List<HistoriqueDocumentDemande> listHDD()  {
		Query req=em.createQuery("select c from HistoriqueDocumentDemande c");
		return req.getResultList();
	}
	public HistoriqueDocumentDemande getHDD(Long idHDD) {
		return em.find(HistoriqueDocumentDemande.class, idHDD);	
	}
	public void supprimerHDD(Long idHDD){
		HistoriqueDocumentDemande c=  em.find(HistoriqueDocumentDemande.class, idHDD);
		em.remove(c);
	}
	public void modifierHDD(HistoriqueDocumentDemande r){
		em.merge(r);	
	}

				/******** HistoriquePrerequisDemande *********/

	public Long ajouterHPD(HistoriquePrerequisDemande r){
		em.persist(r);
		return r.getId();
	}
	@SuppressWarnings("unchecked")
	public List<HistoriquePrerequisDemande> listHPD()  {
		Query req=em.createQuery("select c from HistoriquePrerequisDemande c");
		return req.getResultList();
	}
	public HistoriquePrerequisDemande getHPD(Long idHPD) {
	return em.find(HistoriquePrerequisDemande.class, idHPD);	
	}
	public void supprimerHPD(Long idHPD){
		HistoriquePrerequisDemande c=  em.find(HistoriquePrerequisDemande.class, idHPD);
		em.remove(c);
	}
	public void modifierHPD(HistoriquePrerequisDemande r){
		em.merge(r);	

	}


	/******** HistoriqueServiceDemande  *********/
	
	@Override
	public Long ajouterHSD(HistoriqueServiceDemande r) {
		em.persist(r);
		return r.getId();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<HistoriqueServiceDemande> listHSD() {
		Query req=em.createQuery("select c from historique_typ_pre c");
        return req.getResultList();
	}
	@Override
	public HistoriqueServiceDemande getHSD(Long idHSD) {
		return em.find(HistoriqueServiceDemande.class, idHSD);
	}
	@Override
	public void supprimerHSD(Long idHSD) {
		HistoriqueServiceDemande c=  em.find(HistoriqueServiceDemande.class, idHSD);
		 em.remove(c);
		
	}
	@Override
	public void modifierHSD(HistoriqueServiceDemande r) {
		em.merge(r);	
		
	}
	
}
