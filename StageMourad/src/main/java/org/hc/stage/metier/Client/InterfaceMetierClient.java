package org.hc.stage.metier.Client;

import org.hc.stage.entities.acteurs.Client;
import org.hc.stage.entities.demandes.Demande;
import org.hc.stage.entities.demandes.DocumentDeDemande;
import org.hc.stage.entities.demandes.PrerequisDeDemande;
public interface InterfaceMetierClient {
	
	public Long ajouterNouveauClient(Client client);

	public Long creerNouvelleDemande(Demande demande, Client client, String id);
	public Long AjouterNouveauDocumentDemande(DocumentDeDemande doD, Client client);
	public Long AjouterNouveauPrerequi(PrerequisDeDemande prD, Client client);
}
