package org.hc.stage;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hc.stage.entities.acteurs.Client;
import org.hc.stage.metier.Client.InterfaceMetierClient;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMetierClient {
	ClassPathXmlApplicationContext context ;
	@org.junit.Before
	public void setUp() throws Exception
	{
		context =
				 new ClassPathXmlApplicationContext(
						 new String[]{"applicationContext.xml"});
	}	

	@Test
	public void test() {
		try{
			InterfaceMetierClient metierClient = (InterfaceMetierClient) context.getBean("metierClient");
			
			/************ ajouter client ***********/
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = dateFormat.parse("20-02-1990");
			Client client = new Client("hamila","nazih",date,"hamila-nezih@gmail.com","hamila","hamila");
			Long idCli = metierClient.ajouterNouveauClient(client);	
			client.setId(idCli);
			
			/************ ajouter demande ***********/
			
		//	Demande demande = new Demande();
		//	metierClient.creerNouvelleDemande(demande, client,"1");
			
			
           /************ test ajouter type demande avec l'historique ***********/
			
		    //DocumentDemande documentDemande = new DocumentDemande("eeee");
			//metierClient.AjouterNouveauDocumentDemande(documentDemande, client);
			/************ test ajouter type document avec l'historique***********/
			
			//PrerequisDemande prerequisDemande = new PrerequisDemande("klk");
			//metierClient.AjouterNouveauPrerequis(prerequisDemande, client);	
			
			/************ test ajout type prerequis avec l'historique ***********/
			
		
			
		     assertTrue(true);
			 		
		 }catch(Exception e)
		 {
			 assertTrue(e.getMessage(),false);
		 }
		}

	

}
