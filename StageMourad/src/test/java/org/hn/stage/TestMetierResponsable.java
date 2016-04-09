package org.hn.stage;

import static org.junit.Assert.*;

import org.hn.stage.entities.acteurs.Responsable;
import org.hn.stage.entities.acteurs.Utilisateur;
import org.hn.stage.entities.typeDemandes.DocumentTypeDemande;
import org.hn.stage.entities.typeDemandes.PrerequisTypeDemande;
import org.hn.stage.entities.typeDemandes.TypeDemande;
import org.hn.stage.metier.responsable.InterfaceMetierResponsable;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMetierResponsable {
	ClassPathXmlApplicationContext context ;
	@org.junit.Before
	public void setUp() throws Exception
	{
		context =
				 new ClassPathXmlApplicationContext(
						 new String[]{"applicationContext.xml"});
	}	
	@Test
	public void testImpMetierResponsable() {
		try{
			InterfaceMetierResponsable metierResponsable = (InterfaceMetierResponsable) context.getBean("metierResponsable");
			
			/************ ajouter responsable ***********/
			
			Responsable responsable = new Responsable("responsable","BAHLOUL","Mourad");
			Long idRes = metierResponsable.ajouterNouveauResponsable(responsable);	
			responsable.setId(idRes);
			
			/************ ajouter responsable ***********/
			
			Utilisateur utilisateur = new Utilisateur("sous directeur","hamila","nazih");
			metierResponsable.ajouterNouveauUtilisateur(utilisateur);	
			responsable.setId(idRes);
			
           /************ test ajouter type demande avec l'historique ***********/
			
		    TypeDemande typeDemande = new TypeDemande("passeport");			
			metierResponsable.ajouterNouveauTypeDemande(typeDemande, responsable);	
			responsable.setId(idRes);
			
			/************ test ajouter type document avec l'historique***********/
			
			DocumentTypeDemande documentTypeDemande = new DocumentTypeDemande("photocopie de carte d'identitier",true,typeDemande);
			metierResponsable.AjouterNouveauTypeDocumentDemande(documentTypeDemande, responsable);	
			
			/************ test ajout type prerequis avec l'historique ***********/
			
			PrerequisTypeDemande prerequisTypeDemande = new PrerequisTypeDemande("nom",true,typeDemande);
			metierResponsable.AjouterNouveauTypePrerequis(prerequisTypeDemande, responsable);
			
		     assertTrue(true);
			 		
		 }catch(Exception e)
		 {
			 assertTrue(e.getMessage(),false);
		 }
		}

}
