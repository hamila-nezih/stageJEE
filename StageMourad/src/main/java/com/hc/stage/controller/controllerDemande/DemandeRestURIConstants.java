package com.hc.stage.controller.controllerDemande;

public class DemandeRestURIConstants {
	
	public static final String GET_TYPE_DEMANDE = "/typeDemande/getTypeDemand/{id}";
	public static final String CREER_DEMANDE = "/demande/create";	
	public static final String CREER_PRESREQUIS = "/prerequis/create";
	public static final String CREER_DOCUMENT = "/document/create";
	
	public static final String HISTORIQUE_DEMANDE = "/demande/historiqueDemande";	
	public static final String HISTORIQUE_PRESREQUIS = "/demande/historiquePrerequis";
	public static final String HISTORIQUE_DOCUMENT = "/demande/historiqueDocument";
	
	public static final String GET_DEMANDE_HISTORIQUE = "/demande/getDemandeHistorique/{id}";
	public static final String GET_PREREQUIS_HISTORIQUE = "/demande/getPrerequisHistorique/{id}";
	public static final String GET_DOCUMENTS_HISTORIQUE = "/demande/getDocumentsHistorique/{id}";

	
	public static final String GET_DEMANDES_ENCOURS = "/demande/getDemandesEncours/{id}";
	public static final String GET_DEMANDES_CLOTURES = "/demande/getDemandesClotures/{id}";
	
	public static final String GET_PREREQUIS = "/demande/getPrerequis/{idDmd}";
	public static final String GET_DOCUMENTS = "/demande/getDocuments/{idDmd}";
	public static final String GET_DOCUMENT = "/demande/downloadFile/{idDocument}";
	
	public static final String GET_DEMANDES_PAR_TYPE = "/demande/getDemandeParType/{id}";

	
	 public static final String GET_TYPE_PREREQUIS_DEMANDE = "/client/getTPDmd/{id}";
	 public static final String GET_TOUS_TYPE_DEMANDE = "/client/getTTDmd";
	 
     public static final String UPDATE_DEMANDE = "/demande/update";
     public static final String DELETE_TYPE_DEMANDE = "/demande/deleteTypeDemande/{id}";
	 


}
