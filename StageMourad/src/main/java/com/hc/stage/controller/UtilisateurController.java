package com.hc.stage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hc.stage.entities.acteurs.Utilisateur;
import com.hc.stage.entities.types.typesDeDemandes.PrerequisTypeDemande;
import com.hc.stage.metier.utilisateur.InterfaceMetierUtilisateur;
import org.springframework.http.HttpStatus;

@Controller
public class UtilisateurController {
	
	@Autowired
	private InterfaceMetierUtilisateur iMetierUtilisateur ;
	
	@RequestMapping(value = UtilisateurRestURIConstants.GET_TOUS_UTL, method = RequestMethod.GET,
			produces={"application/json"})
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Utilisateur> selectALL(Model model){		
		
		return iMetierUtilisateur.getTousUtl();		
	}
	
	@RequestMapping(value = UtilisateurRestURIConstants.GET_UTL, method = RequestMethod.GET) 
	 public @ResponseBody Utilisateur selectUtl(@PathVariable String id) {  
	   
		return new Utilisateur();		
	 }  
	
	@RequestMapping(value = UtilisateurRestURIConstants.UPDATE_UTL, method = RequestMethod.POST) 
	 public @ResponseBody Utilisateur upDateUtl(@PathVariable Long id, @PathVariable String libelle, @PathVariable String nom,
			 @PathVariable String prenom){	   
	   
		return iMetierUtilisateur.upDateUtl(id, libelle, nom, prenom);		
	 }  
	
	@RequestMapping(value = UtilisateurRestURIConstants.CREER_UTL, method = RequestMethod.PUT) 
	 public @ResponseBody void creerUtl(@PathVariable String libelle, @PathVariable String nom,
			 @PathVariable String prenom){	
		
		Utilisateur uti =new Utilisateur(libelle,nom,prenom);
	    iMetierUtilisateur.ajouterNouvelUtilisateur(uti);	
	    
	 }  
	
	@RequestMapping(value = UtilisateurRestURIConstants.SUPPRIMER_UTL, method = RequestMethod.DELETE) 
	 public @ResponseBody List<Utilisateur>  deleteUul(@PathVariable String id) {  
	   
		iMetierUtilisateur.supprimierUtl(Long.parseLong(id));
		return iMetierUtilisateur.getTousUtl();	
			
	 }  
	//////////////////////////////////////////
	
	@RequestMapping(value = UtilisateurRestURIConstants.CREER_TPrerequis, method = RequestMethod.GET,
			produces={"application/json"})
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<PrerequisTypeDemande> getPrerequisDemande(@PathVariable String id){		
		
		return iMetierUtilisateur.getTypePrerequisD(Long.parseLong(id));	
	}
	
}
