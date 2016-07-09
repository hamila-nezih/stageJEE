package com.hc.stage.controller.controllerClient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hc.stage.controller.UtilisateurRestURIConstants;
import com.hc.stage.entities.acteurs.Client;
import com.hc.stage.entities.acteurs.Utilisateur;
import com.hc.stage.entities.types.typesDeDemandes.PrerequisTypeDemande;
import com.hc.stage.entities.types.typesDeDemandes.TypeDemande;
import com.hc.stage.metier.Client.InterfaceMetierClient;

@Controller

public class ClientController {

	@Autowired
	private InterfaceMetierClient iMetierClient;

	@RequestMapping(value = ClientRestURIConstants.CREER_CLIENT, method = RequestMethod.POST, consumes = "application/json;"
			+ "charset=UTF-8")
	public @ResponseBody List<Client> creerUtl(@RequestBody Client client) {

		iMetierClient.ajouterNouveauClient(client);
		return iMetierClient.connexion(client.getMail(), client.getMotsPasse());
	}

	@RequestMapping(value = ClientRestURIConstants.GET_TOUS_TYPE_DEMANDE, method = RequestMethod.GET, produces = {
			"application/json" })

	@ResponseStatus(HttpStatus.OK)

	public @ResponseBody List<TypeDemande> selectAllTypeDemande() {

		return iMetierClient.getAllTypeDemande();
	}

	@RequestMapping(value = ClientRestURIConstants.GET_TYPE_DEMANDE, method = RequestMethod.GET, produces = {
			"application/json" })

	@ResponseStatus(HttpStatus.OK)

	public @ResponseBody TypeDemande selectFullTypeDemande(@PathVariable String id) {

		return iMetierClient.getTypeDemande(Long.parseLong(id));
	}

	@RequestMapping(value = ClientRestURIConstants.GET_TYPE_PREREQUIS_DEMANDE, method = RequestMethod.GET, produces = {
			"application/json" })

	@ResponseStatus(HttpStatus.OK)

	public @ResponseBody List<PrerequisTypeDemande> selectPrerequisTypeDemande(@PathVariable String id) {

		return iMetierClient.getPrerequisTypeDemande(Long.parseLong(id));
	}

	@RequestMapping(value = ClientRestURIConstants.GET_CLIENT, method = RequestMethod.GET, produces = {
			"application/json" })

	@ResponseStatus(HttpStatus.OK)

	public @ResponseBody Client findClientId(@PathVariable String id) {
		System.out.println(iMetierClient.findClientId(Long.parseLong(id)).getDateNaissance());
		return iMetierClient.findClientId(Long.parseLong(id));
	}
	
	
	@RequestMapping(value = ClientRestURIConstants.GET_CLIENT_CONNEXION, method = RequestMethod.GET, produces = {
			"application/json" })

	@ResponseStatus(HttpStatus.OK)

	public @ResponseBody List<Client> findClient(@PathVariable String login, @PathVariable String password) {
		return iMetierClient.connexion(login, password);
	}
	
	@RequestMapping(value = ClientRestURIConstants.UPDATE_CLIENT, method = RequestMethod.PUT)
	public @ResponseBody void upDateUtl(@RequestBody Client client) {
		 iMetierClient.updateClient(client);
	}
}
