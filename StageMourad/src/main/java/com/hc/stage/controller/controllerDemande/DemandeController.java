package com.hc.stage.controller.controllerDemande;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.hc.stage.entities.demandes.Demande;
import com.hc.stage.entities.demandes.DocumentDeDemande;
import com.hc.stage.entities.demandes.PrerequisDeDemande;
import com.hc.stage.entities.historisation.historisationDesDemandes.HistoriqueDemande;
import com.hc.stage.entities.historisation.historisationDesDemandes.HistoriqueDocumentDemande;
import com.hc.stage.entities.historisation.historisationDesDemandes.HistoriquePrerequisDemande;
import com.hc.stage.entities.types.typesDeDemandes.DocumentTypeDemande;
import com.hc.stage.entities.types.typesDeDemandes.TypeDemande;
import com.hc.stage.metier.Client.InterfaceMetierClient;

@Controller

public class DemandeController {

	@Autowired
	private InterfaceMetierClient iMetierClient;

	@RequestMapping(value = DemandeRestURIConstants.GET_TYPE_DEMANDE, method = RequestMethod.GET, produces = {
			"application/json" })

	@ResponseStatus(HttpStatus.OK)

	public @ResponseBody TypeDemande selectFullTypeDemande(@PathVariable String id) {

		return iMetierClient.getTypeDemande(Long.parseLong(id));
	}

	@RequestMapping(value = DemandeRestURIConstants.CREER_PRESREQUIS, method = RequestMethod.POST, consumes = "application/json;"
			+ "charset=UTF-8", produces = { "application/json" })

	public @ResponseBody void creerPrerequis(@RequestBody PrerequisDeDemande prerequisDeDemande) {

		iMetierClient.creerNouveauPrerequis(prerequisDeDemande);

	}

	@RequestMapping(value = DemandeRestURIConstants.CREER_DEMANDE, method = RequestMethod.POST, consumes = "application/json;"
			+ "charset=UTF-8", produces = { "application/json" })

	public @ResponseBody Demande creerDemande(@RequestBody Demande demande) {

		Long id = iMetierClient.creerNouvelleDemande(demande, demande.getClient().getId(),
				demande.getTypeDemande().getId());
		Demande d = new Demande();
		d.setId(id);
		return d;
	}

	@RequestMapping(value = DemandeRestURIConstants.CREER_DOCUMENT, method = RequestMethod.POST)
	public @ResponseBody void uploadFileHandler(@RequestParam("file") MultipartFile file,
			@RequestParam("name") String name, @RequestParam("idD") String idD,
			@RequestParam("idTypeDocument") String idTD) {
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				DocumentDeDemande documentDeDemandeDemande = new DocumentDeDemande();
				documentDeDemandeDemande.setContenue(bytes);
				documentDeDemandeDemande.setNomFichier(name);
				Demande demande = new Demande();
				demande.setId(Long.parseLong(idD));
				documentDeDemandeDemande.setDemande(demande);
				// * Recuperation la date du systeme
				Date actuelle = new Date();
				documentDeDemandeDemande.setDateCreation(actuelle);
				DocumentTypeDemande documentTypeDemande = new DocumentTypeDemande();
				documentTypeDemande.setId(Long.parseLong(idTD));
				documentDeDemandeDemande.setDocumentTypeDemandes(documentTypeDemande);
				iMetierClient.creerNouveauDocument(documentDeDemandeDemande);

			} catch (Exception e) {
				// return "You failed to upload " + name + " => " +
				// e.getMessage();
			}
		} else {
			// return "You failed to upload " + name
			// + " because the file was empty.";
		}
	}

	@RequestMapping(value = DemandeRestURIConstants.HISTORIQUE_DEMANDE, method = RequestMethod.POST, consumes = "application/json;"
			+ "charset=UTF-8", produces = { "application/json" })

	public @ResponseBody HistoriqueDemande enregistrerhistoriquedemande(
			@RequestBody HistoriqueDemande historiqueDemande) {

		return iMetierClient.creerHistoriqueDemande(historiqueDemande);

	}

	@RequestMapping(value = DemandeRestURIConstants.HISTORIQUE_PRESREQUIS, method = RequestMethod.POST, consumes = "application/json;"
			+ "charset=UTF-8", produces = { "application/json" })

	public @ResponseBody void enregistrerHistoriquePrerequis(
			@RequestBody HistoriquePrerequisDemande historiquePrerequisDemande) {

		iMetierClient.creerHistoriquePrerequis(historiquePrerequisDemande);

	}

	@RequestMapping(value = DemandeRestURIConstants.HISTORIQUE_DOCUMENT, method = RequestMethod.POST, consumes = "application/json;"
			+ "charset=UTF-8", produces = { "application/json" })

	public @ResponseBody void enregistrerHistoriqueDocument(
			@RequestBody HistoriqueDocumentDemande historiqueDocumentDemande) {
		iMetierClient.creerHistoriqueDocument(historiqueDocumentDemande);

	}

	@RequestMapping(value = DemandeRestURIConstants.GET_DEMANDES_ENCOURS, method = RequestMethod.GET, produces = {
			"application/json" })

	@ResponseStatus(HttpStatus.OK)

	public @ResponseBody List<Demande> getDemandes(@PathVariable String id) {

		return iMetierClient.getDemandes(Long.parseLong(id));
	}

	@RequestMapping(value = DemandeRestURIConstants.GET_DEMANDES_CLOTURES, method = RequestMethod.GET, produces = {
			"application/json" })

	@ResponseStatus(HttpStatus.OK)

	public @ResponseBody List<Demande> getDemandesClotures(@PathVariable String id) {

		return iMetierClient.getDemandesCloture(Long.parseLong(id));
	}

	@RequestMapping(value = DemandeRestURIConstants.GET_DEMANDE_HISTORIQUE, method = RequestMethod.GET, produces = {
			"application/json" })

	@ResponseStatus(HttpStatus.OK)

	public @ResponseBody List<Demande> getDemandesHistorique(@PathVariable String id) {

		return iMetierClient.getDemandeHistorique(Long.parseLong(id));
	}

	@RequestMapping(value = DemandeRestURIConstants.GET_DEMANDES_PAR_TYPE, method = RequestMethod.GET, produces = {
			"application/json" })

	@ResponseStatus(HttpStatus.OK)

	public @ResponseBody List<Demande> getDemandesParType(@PathVariable String id) {

		return iMetierClient.getDemandeParType(Long.parseLong(id));
	}

	@RequestMapping(value = DemandeRestURIConstants.GET_PREREQUIS_HISTORIQUE, method = RequestMethod.GET, produces = {
			"application/json" })

	@ResponseStatus(HttpStatus.OK)

	public @ResponseBody List<PrerequisDeDemande> getPrerequisHistorique(@PathVariable String id) {

		return iMetierClient.getPrerequisHist(Long.parseLong(id));
	}

	@RequestMapping(value = DemandeRestURIConstants.GET_DOCUMENTS_HISTORIQUE, method = RequestMethod.GET, produces = {
			"application/json" })

	@ResponseStatus(HttpStatus.OK)

	public @ResponseBody List<DocumentDeDemande> getDocumentsHistorique(@PathVariable String id) {

		return iMetierClient.getDocumentsHist(Long.parseLong(id));
	}

	@RequestMapping(value = DemandeRestURIConstants.GET_PREREQUIS, method = RequestMethod.GET, produces = {
			"application/json" })

	@ResponseStatus(HttpStatus.OK)

	public @ResponseBody List<PrerequisDeDemande> selectPrerequis(@PathVariable String idDmd) {

		return iMetierClient.getPrerequis(Long.parseLong(idDmd));
	}

	@RequestMapping(value = DemandeRestURIConstants.GET_DOCUMENTS, method = RequestMethod.GET, produces = {
			"application/json" })

	@ResponseStatus(HttpStatus.OK)

	public @ResponseBody List<DocumentDeDemande> selectDocuments(@PathVariable String idDmd) {

		return iMetierClient.getDocuments(Long.parseLong(idDmd));
	}

	@RequestMapping(value = DemandeRestURIConstants.DELETE_TYPE_DEMANDE, method = RequestMethod.DELETE)

	public @ResponseBody void deleteTypeDemande(@PathVariable String id) {

		iMetierClient.deleteTypeDemande(Long.parseLong(id));
		;
	}

	@RequestMapping(value = DemandeRestURIConstants.UPDATE_DEMANDE, method = RequestMethod.PUT, consumes = "application/json;"
			+ "charset=UTF-8")
	public @ResponseBody void updateDemande(@RequestBody Demande demande) {
		iMetierClient.updateDemande(demande);

	}

	/*
	 * download
	 */
	@RequestMapping(value = DemandeRestURIConstants.GET_DOCUMENT, method = RequestMethod.GET)
	public @ResponseBody byte[] getOpenedEventsInPdf(HttpServletResponse response, @PathVariable String idDocument) {
		DocumentDeDemande documentDeDemande = iMetierClient.download(Long.parseLong(idDocument));
		String filename = documentDeDemande.getNomFichier();
		String extension = FilenameUtils.getExtension(filename);
		response.setHeader("Content-Disposition", "inline; filename=" + filename);
		response.setContentType("application/" + extension);
		byte[] file = documentDeDemande.getContenue();
		return file;

	}

	@RequestMapping(value = DemandeRestURIConstants.GET_DEMANDE_HISTORIQUE_ENCOURS, method = RequestMethod.GET
			, produces = {"application/json" })
	@ResponseStatus(HttpStatus.OK)

	public @ResponseBody List<Demande> getDemandeHistEncours(@PathVariable String id) {

		return iMetierClient.getDemandeHistoriqueEncours(Long.parseLong(id));
	}

	@RequestMapping(value = DemandeRestURIConstants.GET_HISTORIQUE_DEMANDE_ENCOURS, method = RequestMethod.GET
			, produces = {"application/json" })
	@ResponseStatus(HttpStatus.OK)

	public @ResponseBody List<HistoriqueDemande> getHistDemandeEncours(@PathVariable String id) {

		return iMetierClient.getHistoriqueDEmandeEncours(Long.parseLong(id));
	}

}
