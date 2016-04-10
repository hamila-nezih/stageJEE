package org.hn.stage.metier.Client;

import org.hn.stage.entities.acteurs.Client;
import org.hn.stage.entities.demandes.Demande;
import org.hn.stage.entities.demandes.DocumentDemande;
import org.hn.stage.entities.demandes.PrerequisDemande;
public interface InterfaceMetierClient {
	
	public Long ajouterNouveauClient(Client client);

	public Long creerNouveauDemande(Demande demande, Client client, String id);
	public Long AjouterNouveauDocumentDemande(DocumentDemande doD, Client client);
	public Long AjouterNouveauPrerequis(PrerequisDemande prD, Client client);
}
