package com.hc.stage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hc.stage.entities.acteurs.Utilisateur;
import com.hc.stage.entities.demandes.Demande;
import com.hc.stage.entities.historisation.historisationDesTypesDeDemandes.HistoriqueTypeDemande;
import com.hc.stage.entities.types.typesDeDemandes.DocumentTypeDemande;
import com.hc.stage.entities.types.typesDeDemandes.PrerequisTypeDemande;
import com.hc.stage.entities.types.typesDeDemandes.TypeDemande;
import com.hc.stage.metier.Client.ImpIntMetierClient;
import com.hc.stage.metier.utilisateur.InterfaceMetierUtilisateur;

@Controller
public class UtilisateurController {

	@Autowired
	private InterfaceMetierUtilisateur iMetierUtilisateur;

	@RequestMapping(value = UtilisateurRestURIConstants.GET_TOUS_UTL, method = RequestMethod.GET, produces = {
			"application/json" })
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Utilisateur> selectALL(Model model) {

		return iMetierUtilisateur.getTousUtl();
	}

	@RequestMapping(value = UtilisateurRestURIConstants.GET_UTL, method = RequestMethod.GET)
	public @ResponseBody Utilisateur selectUtl(@PathVariable String id) {

		return iMetierUtilisateur.getUtilisateur(Long.parseLong(id));
	}

	@RequestMapping(value = UtilisateurRestURIConstants.UPDATE_UTL, method = RequestMethod.POST)
	public @ResponseBody Utilisateur upDateUtl(@PathVariable Long id, @PathVariable String libelle,
			@PathVariable String nom, @PathVariable String prenom) {

		return iMetierUtilisateur.upDateUtl(id, libelle, nom, prenom);
	}

	@RequestMapping(value = UtilisateurRestURIConstants.UPDATE_UTL, method = RequestMethod.PUT, consumes = "application/json;"
			+ "charset=UTF-8")
	public @ResponseBody void updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateur utl) {

		iMetierUtilisateur.upDateUtl(id, utl.getLibelle(), utl.getNom(), utl.getPrenom());

	}

	@RequestMapping(value = UtilisateurRestURIConstants.CREER_UTL, method = RequestMethod.POST, consumes = "application/json;"
			+ "charset=UTF-8")
	public @ResponseBody void creerUtl(@RequestBody Utilisateur utl) {

		iMetierUtilisateur.ajouterNouvelUtilisateur(utl);

	}

	@RequestMapping(value = UtilisateurRestURIConstants.SUPPRIMER_UTL, method = RequestMethod.DELETE)
	public @ResponseBody List<Utilisateur> deleteUul(@PathVariable String id) {

		iMetierUtilisateur.supprimierUtl(Long.parseLong(id));
		return iMetierUtilisateur.getTousUtl();

	}

	@RequestMapping(value = UtilisateurRestURIConstants.CREER_TYPE_DEMANDE, method = RequestMethod.POST, consumes = "application/json;"
			+ "charset=UTF-8")
	public @ResponseBody TypeDemande creerTypeDemande(@RequestBody TypeDemande typeDemande) {

		return iMetierUtilisateur.creerNouveauTypeDemande(typeDemande);

	}

	@RequestMapping(value = UtilisateurRestURIConstants.CREER_TYPE_DOCUMENT, method = RequestMethod.POST)
	public @ResponseBody void creerTypeDocument(
			@RequestParam("libelle") String libelle, @RequestParam("ordre") String ordre,
			@RequestParam("obligatoire") Boolean obligatoire, @RequestParam("id") String id) {
 
		TypeDemande typeDemande = iMetierUtilisateur.getTypeDemande(Long.parseLong(id));
		DocumentTypeDemande documentTypeDemande;
		if(ordre.length() > 1){
			documentTypeDemande = new DocumentTypeDemande(libelle, obligatoire,ordre.substring(1));
		}else{
			 documentTypeDemande = new DocumentTypeDemande(libelle, obligatoire,ordre);

		}
		documentTypeDemande.setTypeDemande(typeDemande);
		iMetierUtilisateur.creerNouveauTypeDocumentDemande(documentTypeDemande);

	}

	@RequestMapping(value = UtilisateurRestURIConstants.CREER_TYPE_PREREQUIS, method = RequestMethod.POST)
	public @ResponseBody void creerPrerequisTypeDemannde(@RequestParam("tybeVariable") String tybeVariable,
			@RequestParam("libelle") String libelle, @RequestParam("ordre") String ordre,
			@RequestParam("obligatoire") Boolean obligatoire, @RequestParam("id") String id) {

		TypeDemande typeDemande = iMetierUtilisateur.getTypeDemande(Long.parseLong(id));
		PrerequisTypeDemande prerequisTypeDemande = new PrerequisTypeDemande(libelle, obligatoire, tybeVariable, ordre);
		prerequisTypeDemande.setTypeDemande(typeDemande);
		iMetierUtilisateur.creerNouveauTypePrerequisDemande(prerequisTypeDemande);
	}
	
	@RequestMapping(value = UtilisateurRestURIConstants.GET_ALL_HISTORIQUE_TYPE_DEMANDE, method = RequestMethod.GET)
	public @ResponseBody List<HistoriqueTypeDemande> getAllHistoriquesTypeDemandes() {

		return iMetierUtilisateur.getAllHistoriqueTypeDemande();
	}
	
	

}
