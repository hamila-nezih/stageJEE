package com.hc.stage.controller;

public class UtilisateurRestURIConstants {
	
	 public static final String CREER_UTL = "/utilisateur/create";
	 public static final String GET_UTL = "/utilisateur/get/{id}";
	 public static final String GET_TOUS_UTL = "/utilisateur/getAll";
     public static final String SUPPRIMER_UTL = "/utilisateur/supprimer/{id}";
     public static final String UPDATE_UTL = "/utilisateur/update/{id}";
     
     public static final String CREER_TYPE_DEMANDE = "/utilisateur/CreateTypeDemande";
     public static final String CREER_TYPE_PREREQUIS = "/utilisateur/CreateTypePrerequisDemande";
     public static final String CREER_TYPE_DOCUMENT = "/utilisateur/CreateTypeDocumentDemande";
     
     public static final String GET_ALL_HISTORIQUE_TYPE_DEMANDE = "/utilisateur/getAllHistoriqueTypeDemandes";
     public static final String GET_ALL_DEMANDE_En_ATTENTE = "/utilisateur/getAllDemandesEnAttente";
     

}
